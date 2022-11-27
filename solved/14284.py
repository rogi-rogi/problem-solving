from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) :
    dist = [inf] * (n + 1)
    dist[v] = 0
    pq = [(0, v)]
    while pq :
        w, v = heappop(pq)
        if v == t : return dist
        if dist[v] < w : continue
        for nv, nw in edges[v].items() :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
    return dist

if __name__ == "__main__" :
    n, m = map(int, input().split())
    edges = [dict() for _ in range(n + 1)]
    for _ in range(m) :
        a, b, c = map(int, input().split())
        edges[a][b] = min(edges[a][b], c) if b in edges[a].keys() else c
        edges[b][a] = min(edges[b][a], c) if a in edges[b].keys() else c
    s, t = map(int, input().split())
    dist = Dijkstra(s)
    print(dist[t])
