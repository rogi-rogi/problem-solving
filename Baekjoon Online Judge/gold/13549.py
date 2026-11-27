from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) :
    dist = [inf] * (100001)
    dist[v] = 0
    pq = [(0, v)]
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue
        for nv, nw in [(v - 1, 1), (v + 1, 1), (2 * v, 0)] :
            if 0 <= nv <= 100000 and w + nw < dist[nv] :
                dist[nv] = w + nw
                heappush(pq, (w + nw, nv))
    return dist[M]

if __name__ == "__main__" :
    N, M = map(int, input().split())
    print(Dijkstra(N))
