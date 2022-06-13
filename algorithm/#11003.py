# queue ver.
from collections import deque

if __name__ == "__main__" :
    N, L = map(int, input().split())
    D = []
    pq = deque()
    for idx, a in enumerate([*map(int, input().split())]) :
        while pq and pq[-1][1] > a : pq.pop()
        while pq and idx - pq[0][0] >= L : pq.popleft()
        pq.append((idx, a))
        D.append(pq[0][1])
    print(*D)
