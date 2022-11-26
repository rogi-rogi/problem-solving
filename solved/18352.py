from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) :
    dist = [inf] * (N + 1)
    dist[v] = 0
    pq = [(0, v)]
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue
        w += 1
        for nv in edges[v] :
            if w < dist[nv] :
                dist[nv] = w
                heappush(pq, (w, nv))
    return dist

if __name__ == "__main__" :
    N, M, K, X = map(int, input().split())
    edges = [[] for _ in range(N + 1)]
    for _ in range(M) :
        A, B = map(int, input().split())
        edges[A].append(B)
    dist = Dijkstra(X)
    res = []
    for idx, d in enumerate(dist) :
        if d == K : res.append(idx)
    if res : print(*res, sep = '\n')
    else : print(-1)
