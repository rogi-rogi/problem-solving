"""Shared solved.ac v4 lookup and BOJ file classification."""
import json
import os
import re
import time
from collections import defaultdict
from datetime import datetime, timezone
from email.utils import parsedate_to_datetime
from http.client import HTTPException
from pathlib import Path
from urllib.error import HTTPError, URLError
from urllib.request import Request, urlopen

ROOT = Path(__file__).resolve().parents[3]
BOJ = Path("baekjoon-online-judge")
STATE = BOJ / "_sync_state"
TIERS = ("bronze", "silver", "gold", "platinum", "diamond", "ruby")


def tier(level):
    if type(level) is not int or not 0 <= level <= 30:
        raise ValueError(f"지원하지 않는 레벨 {level!r}")
    return TIERS[(level - 1) // 5] if level else "unrated"


def label(level):
    if not level:
        return tier(level)
    return tier(level).title() + " " + ("V", "IV", "III", "II", "I")[(level - 1) % 5]


def retry_delay(header, attempt):
    if not header:
        return 2 ** attempt
    try:
        return max(0, float(header))
    except ValueError:
        return max(0, parsedate_to_datetime(header).timestamp() - time.time())


def http_failure(page, exc):
    reason = f"목록 {page}페이지 HTTP {exc.code}"
    if exc.headers.get("cf-mitigated", "").lower() == "challenge":
        return f"{reason} — Cloudflare 확인 페이지가 반환됨"
    if exc.headers.get_content_type() == "application/json":
        try:
            body = json.loads(exc.read(8192))
            error = body.get("error") if isinstance(body, dict) else None
            code = error.get("code") if isinstance(error, dict) else None
            if isinstance(code, str) and re.fullmatch(r"[A-Z][A-Z0-9_]{0,79}", code):
                return f"{reason} — solved.ac 오류 코드 {code}"
        except (ValueError, OSError, HTTPException):
            pass
    return f"{reason} — 응답 유형 {exc.headers.get_content_type()}"


def fetch_page(page, headers):
    url = f"https://solved.ac/api/v4/problems?sort=id&direction=asc&page={page}"
    for attempt in range(5):
        try:
            with urlopen(Request(url, headers=headers), timeout=30) as response:
                return json.load(response)
        except HTTPError as exc:
            if exc.code not in (429, 500, 502, 503, 504) or attempt == 4:
                raise RuntimeError(http_failure(page, exc)) from exc
            delay = retry_delay(exc.headers.get("Retry-After"), attempt)
        except (URLError, TimeoutError, HTTPException) as exc:
            if attempt == 4:
                raise RuntimeError(f"목록 {page}페이지 네트워크 오류") from exc
            delay = 2 ** attempt
        time.sleep(delay)


def lookup(wanted):
    if not wanted:
        return {}
    headers = {"x-client-id": os.environ.get("SOLVED_AC_CLIENT_ID"),
               "x-client-secret": os.environ.get("SOLVED_AC_CLIENT_SECRET")}
    if not all(headers.values()):
        raise RuntimeError("solved.ac 앱 자격 증명 누락")
    levels = {}
    page = 1
    while True:
        data = fetch_page(page, headers)
        if data["page"] != page or data["pageSize"] != 50:
            raise ValueError(f"목록 페이지 불일치 ({page})")
        for problem in data["problems"]:
            for judge in problem["judgeIds"]:
                pid = judge["problemId"]
                if judge["ojId"].lower() == "boj" and pid in wanted:
                    level = problem["level"]
                    tier(level)
                    if pid in levels and levels[pid] != level:
                        raise ValueError(f"BOJ {pid}의 레벨이 일치하지 않음")
                    levels[pid] = level
        if len(levels) == len(wanted) or page * 50 >= data["total"]:
            return levels
        if not data["problems"]:
            raise ValueError(f"목록 {page}페이지가 비어 있음")
        page += 1
        # Search costs 3 units; the default bucket refills 2 units/second.
        time.sleep(1.5)


def run(backup=False):
    os.chdir(ROOT)
    start = datetime.now(timezone.utc)
    sources = [Path("other/solved")] if backup else [BOJ / name for name in TIERS[:5]]
    files = defaultdict(list)
    failures = {}
    moves = []
    changes = []
    count = 0
    unchanged = 0
    errors = []
    history_file = STATE / "levels.json"
    history = {}
    for folder in sources:
        if not folder.is_dir():
            errors.append(f"입력 폴더 없음: {folder}")
            continue
        for path in sorted(folder.rglob("*")):
            if path.name.startswith(".") or not path.is_file():
                continue
            count += 1
            if path.stem.isascii() and path.stem.isdecimal() and int(path.stem) > 0:
                files[str(int(path.stem))].append(path)
            else:
                failures[path] = "파일명에서 문제 번호를 읽을 수 없음"
    try:
        if not backup and history_file.exists():
            history = json.loads(history_file.read_text())
            for level in history.values():
                tier(level)
        levels = lookup(files)
    except (OSError, RuntimeError, ValueError, KeyError, TypeError, AttributeError) as exc:
        errors.append(str(exc))
        levels = {}
    for pid, paths in files.items():
        if pid not in levels:
            for path in paths:
                failures[path] = "조회 미완료" if errors else "목록에서 백준 번호를 찾지 못함"
            continue
        level = levels[pid]
        old_level = history.get(pid)
        if old_level is not None and level != old_level:
            changes.append(f"- BOJ {pid}: {label(old_level)} → {label(level)}")
        for path in paths:
            source = next(folder for folder in sources if folder in path.parents)
            destination = BOJ / tier(level) / path.name
            if source == destination.parent:
                unchanged += 1
                continue
            try:
                destination.parent.mkdir(exist_ok=True)
                # A hard link atomically refuses to replace an existing solution.
                try:
                    os.link(path, destination)
                except FileExistsError:
                    # Resume a move interrupted between link and unlink.
                    if not path.samefile(destination):
                        raise
                path.unlink()
                moves.append(f"- BOJ {pid}: `{path}` → `{destination}` ({label(level)})")
            except FileExistsError:
                failures[path] = f"대상 파일이 이미 존재함: {destination}"
            except OSError as exc:
                failures[path] = str(exc)
        if not backup:
            history[pid] = level
    end = datetime.now(timezone.utc)
    lines = ["# " + ("백업 풀이 분류" if backup else "백준 난이도 동기화"), "",
             f"- 시작(UTC): {start.isoformat(timespec='seconds')}",
             f"- 종료(UTC): {end.isoformat(timespec='seconds')}",
             f"- 대상 파일: {count}개", f"- 난이도 변경(이전 조회 대비): {len(changes)}문제",
             f"- 이동: {len(moves)}파일", f"- 제자리: {unchanged}파일",
             f"- 실패: {len(failures)}파일", ""]
    for title, rows in [("난이도 변경", changes), ("파일 이동", moves),
                        ("실행 오류", errors), ("실패 내역", [f"- `{p}` — {msg}" for p, msg in failures.items()])]:
        if rows:
            lines.extend([f"## {title}", "", *rows, ""])
    report = "\n".join(lines) + "\n"
    print(report)
    if os.environ.get("GITHUB_ACTIONS") and errors:
        for message in errors:
            escaped = message.replace("%", "%25").replace("\r", "%0D").replace("\n", "%0A")
            print(f"::error title=BOJ 난이도 분류::{escaped}")
    if os.environ.get("GITHUB_STEP_SUMMARY"):
        with open(os.environ["GITHUB_STEP_SUMMARY"], "a") as summary:
            summary.write(report)
    if not backup:
        reports = STATE / "run_reports"
        reports.mkdir(parents=True, exist_ok=True)
        (reports / f"report_{start:%Y%m%dT%H%M%S%fZ}.md").write_text(report)
        if levels:
            tmp = history_file.with_suffix(".tmp")
            tmp.write_text(json.dumps(history, indent=2, sort_keys=True) + "\n")
            tmp.replace(history_file)
    return int(bool(failures or errors))
