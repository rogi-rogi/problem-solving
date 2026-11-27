from collections import defaultdict
from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())
    board = [input().strip() for _ in range(N)]
    K = int(input())

    # Solve
    temp = defaultdict(int)
    for info in board:
        temp[info] += 1

    res = 0
    for key, value in temp.items():
        num = key.count('0')
        if K >= num and (K - num) % 2 == 0:
            res = max(res, value)

    # Output
    print(res)