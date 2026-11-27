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
        if v == end : break
        if dist[v] < w : continue
        for nv, nw in edges[v].items() :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
    return dist[end]

if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = [dict() for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges[v1][v2] = w
        edges[v2][v1] = w
    v1, v2 = map(int, input().split())
    path1_weight = Dijkstra(1, v1) + Dijkstra(v1, v2) + Dijkstra(v2, V)
    path2_weight = Dijkstra(1, v2) + Dijkstra(v2, v1) + Dijkstra(v1, V)
    if path1_weight == inf and path2_weight == inf : print(-1)
    else : print(min(path1_weight, path2_weight))
