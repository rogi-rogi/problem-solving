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
    V, E = map(int, input().split())
    edges = [dict() for _ in range(V + 1)]
    path = [0] * (V + 1)
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges[v1][v2] = min(edges[v1][v2], w) if v2 in edges[v1].keys() else w
    v1, v2 = map(int, input().split())
    print(Dijkstra(v1, v2))
    res = []
    flag = v2
    while flag :
        res.append(flag)
        flag = path[flag]
    print(len(res))
    print(*res[::-1])
