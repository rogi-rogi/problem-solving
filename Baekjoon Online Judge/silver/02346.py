from collections import deque
from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())

    # Solve
    idx = 0
    queue = deque((idx + 1, val) for idx, val in enumerate(map(int, input().split())))
    res = []
    while queue:
        idx, gap = queue.popleft()
        res.append(idx)
        if gap > 0:
            queue.rotate(-(gap - 1))
        else:
            queue.rotate(-gap)
            
    # Output
    print(*res)
