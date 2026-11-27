from heapq import heappop, heappush, heapify
from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    N = int(input())
    target = int(input())
    cnt = 0
    if N > 1:
        pq = []
        for _ in range(N - 1):
            heappush(pq, -int(input()))
        while target <= -pq[0]:
            heappush(pq, heappop(pq) + 1)
            target += 1
            cnt += 1
    print(cnt)
