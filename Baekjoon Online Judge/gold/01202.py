from heapq import heappop, heappush
from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    N, K = map(int, input().split())
    gems = sorted([[*map(int, input().split())] for _ in range(N)])
    bags_weight = sorted([int(input()) for _ in range(K)])
    res = 0
    idx = 0
    expensive_gems = []
    for bag_weight in bags_weight:
        while idx < N and gems[idx][0] <= bag_weight:
            heappush(expensive_gems, -gems[idx][1])
            idx += 1
        if expensive_gems:
            res -= heappop(expensive_gems)
    print(res)
