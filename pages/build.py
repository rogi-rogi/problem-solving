"""Build a standalone solution archive from the working tree."""
import base64
import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
COLLECTIONS = (
    "Baekjoon Online Judge", "Programmers", "SW Expert Academy", "Jungol",
    "HackerRank", "Algospot", "Codetree", "goorm", "LeetCode",
    "Algorithm", "templates",
)
COLLECTION_ICONS = {
    "": "tabler/layout-grid.svg",
    "Programmers": "programmers-symbol.png",
    "HackerRank": "fontawesome/hackerrank.svg",
    "Baekjoon Online Judge": "brands/boj.png",
    "SW Expert Academy": "brands/swea.png",
    "Jungol": "brands/jungol.svg",
    "Algospot": "brands/algospot.png",
    "Codetree": "brands/codetree.png",
    "goorm": "brands/goorm.svg",
    "LeetCode": "brands/leetcode.svg",
}
LANGUAGES = {
    "py": "Python", "python": "Python", "java": "Java", "c": "C", "cpp": "C++",
    "sql": "SQL", "txt": "Text", "ada": "Ada", "adb": "Ada", "a68": "ALGOL 68",
    "f90": "Fortran", "f95": "Fortran", "bas": "BASIC", "vb": "Visual Basic",
    "bf": "Brainfuck", "gs": "GolfScript", "cob": "COBOL",
}

def build():
    records = []
    folders = {p.name.casefold().replace("-", " "): p for p in ROOT.iterdir() if p.is_dir()}
    names = {}
    for collection in COLLECTIONS:
        folder = folders[collection.casefold().replace("-", " ")]
        directory = folder.name
        names[collection] = directory
        for path in sorted(folder.rglob("*")):
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
        icons[names.get(key, key)] = f"data:{mime};base64," + base64.b64encode(image).decode("ascii")
    prism = (ROOT / "pages/assets/prism/prism.min.js").read_text()
    output.write_text(template.replace("PRISM_BUNDLE", prism).replace("COLLECTION_ICONS", json.dumps(icons))
                      .replace("ICON_LICENSE", (ROOT / "pages/assets/tabler/LICENSE").read_text()).replace("ARCHIVE_DATA", data))
    print(f"{len(records)} files → {output}")

if __name__ == "__main__":
    build()
