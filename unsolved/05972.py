from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) :
    dist = [inf] * (N + 1)
    dist[v] = 0
    pq =[]
    heappush(pq, (0, v))
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue
        if v == N : return dist
        for nv, nw in edges[v] :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
    return dist

if __name__ == "__main__" :
    N, M = map(int, input().split())
    edges = [[] for _ in range(N + 1)]
    for _ in range(M) :
        A_i, B_i, C_i = map(int, input().split())
        edges[A_i].append((B_i, C_i))
        edges[B_i].append((A_i, C_i))
    dist = Dijkstra(1)
    print(dist[N])
