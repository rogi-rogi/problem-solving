from heapq import heappop, heappush
from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    N = int(input())
    pq = []
    for _ in range(N):
        for num in [*map(int, input().split())]:
            if len(pq) < N:
                heappush(pq, num)
            elif num > pq[0]:
                heappop(pq)
                heappush(pq, num)
    print(pq[0])
