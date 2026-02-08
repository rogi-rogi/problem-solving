from collections import defaultdict
from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        input()
        # Solve
        note = defaultdict(int)
        res = []
        for num in [*map(int, input().split())]:
            note[num] += 1
        input()
        for num in [*map(int, input().split())]:
            res.append(0 if note[num] == 0 else 1)

        # Output
        print(*res, sep='\n')