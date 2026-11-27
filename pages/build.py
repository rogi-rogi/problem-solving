"""Build a standalone solution archive from the working tree."""
import base64
import json
from collections import Counter
from html import escape
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
COLLECTIONS = (
    "baekjoon-online-judge", "Programmers", "SW Expert Academy", "jungol",
    "HackerRank", "other", "Algorithm", "templates",
)
COLLECTION_ICONS = {
    "": "tabler/layout-grid.svg",
    "Programmers": "programmers-symbol.png",
    "HackerRank": "fontawesome/hackerrank.svg",
}
LANGUAGES = {
    "py": "Python", "python": "Python", "java": "Java", "c": "C", "cpp": "C++",
    "sql": "SQL", "txt": "Text", "ada": "Ada", "adb": "Ada", "a68": "ALGOL 68",
    "f90": "Fortran", "f95": "Fortran", "bas": "BASIC", "vb": "Visual Basic",
    "bf": "Brainfuck", "gs": "GolfScript", "cob": "COBOL",
}

def language_summary(records):
    assets = ROOT / "pages/assets"
    filenames = {
        "Python": "seti/python", "Java": "seti/java", "C": "seti/c",
        "C++": "seti/cpp", "SQL": "seti/db", "Text": "material/document",
        "Fortran": "material/fortran", "Ada": "material/ada", "COBOL": "material/cobol",
        "Brainfuck": "material/brainfuck", "Visual Basic": "devicon/visualbasic",
        "GolfScript": "tabler/stack-2", "BASIC": "tabler/terminal", "ALGOL 68": "tabler/hierarchy",
    }
    counts = Counter(row["language"] for row in records)
    tiles, rows = [], []
    for rank, (language, count) in enumerate(counts.most_common(), start=1):
        percent = 100 * count / len(records)
        share = f"{percent:.1f}%" if percent >= 0.1 else "&lt;0.1%"
        name = escape(language)
        image = (assets / (filenames[language] + ".svg")).read_bytes()
        url = "data:image/svg+xml;base64," + base64.b64encode(image).decode("ascii")
        mark = f'<img src="{url}" alt="">'
        rows.append(
            f'<tr><th scope="row"><span class="language-name">{mark}{name}</span></th>'
            f'<td><span class="share-track" aria-hidden="true"><span style="width:{percent:.5f}%"></span></span></td>'
            f'<td>{count:,}</td><td>{share}</td></tr>'
        )
        if rank <= 5:
            tiles.append(f'<span class="language-tile">{mark}<b>{name}</b><span>{share}</span></span>')
    licenses = {
        "seti/LICENSE.md": "https://github.com/jesseweed/seti-ui",
        "material/LICENSE": "https://github.com/material-extensions/vscode-material-icon-theme",
        "devicon/LICENSE": "https://github.com/devicons/devicon",
        "tabler/LICENSE": "https://github.com/tabler/tabler-icons",
    }
    notice = "\n".join(f"{source}\n{(assets / path).read_text()}" for path, source in licenses.items())
    return (f'<!-- Language icon credits: {notice} -->'
            '<div class="language-summary"><button type="button" class="language-open" '
            'aria-haspopup="dialog" aria-label="언어별 파일 비중 전체 보기">'
            '<strong>언어별 파일 비중</strong> <small>전체 보기</small>'
            '<span class="language-icons">' + "".join(tiles) + '</span></button>'
            '<dialog class="language-dialog" aria-label="전체 언어별 파일 비중">'
            '<div class="language-title"><strong>전체 언어별 파일 비중</strong>'
            '<form method="dialog"><button class="modal-close" aria-label="닫기" autofocus>×</button></form></div>'
            f'<p>전체 {len(records):,}개 파일</p><table><thead><tr>'
            '<th scope="col">언어·파일 유형</th><th scope="col" aria-label="전체 파일 대비 비중"></th><th scope="col">파일 수</th><th scope="col">비중</th>'
            '</tr></thead><tbody>' + "".join(rows) + '</tbody></table></dialog></div>')


def build():
    records = []
    for directory in COLLECTIONS:
        for path in sorted((ROOT / directory).rglob("*")):
            rel = path.relative_to(ROOT)
            if not path.is_file() or path.is_symlink() or any(p.startswith(".") for p in rel.parts):
                continue
            language = LANGUAGES.get(path.suffix[1:].lower())
            if not language:
                continue
            raw = path.read_bytes()
            try:
                source = raw.decode("utf-8-sig")
            except UnicodeDecodeError:
                source = raw.decode("cp949")
            records.append(dict(platform=directory, category="/".join(rel.parts[1:-1]),
                                name=path.name, path=rel.as_posix(), language=language, source=source))
    if not records:
        raise ValueError("No solutions found")
    template = (ROOT / "pages/template.html").read_text()
    data = json.dumps(records, ensure_ascii=False, separators=(",", ":")).replace("<", r"\u003c")
    output = ROOT / "out/pages/index.html"
    output.parent.mkdir(parents=True, exist_ok=True)
    icons = {}
    for key, filename in COLLECTION_ICONS.items():
        image = (ROOT / "pages/assets" / filename).read_bytes()
        mime = "image/png" if filename.endswith(".png") else "image/svg+xml"
        icons[key] = f"data:{mime};base64," + base64.b64encode(image).decode("ascii")
    prism = (ROOT / "pages/assets/prism/prism.min.js").read_text()
    output.write_text(template.replace("PRISM_BUNDLE", prism).replace("COLLECTION_ICONS", json.dumps(icons))
                      .replace("LANGUAGE_SUMMARY", language_summary(records)).replace("ARCHIVE_DATA", data))
    print(f"{len(records)} files → {output}")

if __name__ == "__main__":
    build()
