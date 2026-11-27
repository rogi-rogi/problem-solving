# deque ver.
from collections import deque

if __name__ == "__main__" :
    N, L = map(int, input().split())
    D = []
    dq = deque()
    for idx, a in enumerate([*map(int, input().split())]) :
        while dq and dq[-1][1] > a : dq.pop()
        while dq and idx - dq[0][0] >= L : dq.popleft()
        dq.append((idx, a))
        D.append(dq[0][1])
    print(*D)

# pypy3
# priority queue ver.
from heapq import heappush, heappop

if __name__ == "__main__" :
    N, L = map(int, input().split())
    pq = []
    D = []
    for idx, a in enumerate([*map(int, input().split())]) :
        while pq and idx - pq[0][1] >= L : heappop(pq)
        heappush(pq, (a, idx))
        D.append(pq[0][0])
    print(*D)
