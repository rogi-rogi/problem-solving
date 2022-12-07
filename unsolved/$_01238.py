from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(start, end) :
    dist = [inf] * (V + 1)
    dist[start] = 0
    pq = [(0, start)]
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue
        for nv, nw in edges[v].items() :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
                path[nv] = v
    return dist[end]

if __name__ == "__main__" :
    V, E, X = map(int, input().split())
    edges = [dict() for _ in range(V + 1)]
    path = [0] * (V + 1)
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges[v1][v2] = w
    res = 0
    for v in range(1, V + 1) :
        res = max(res, Dijkstra(v, X) + Dijkstra(X, v))
    print(res)
