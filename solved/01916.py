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
        if v == v2 : return dist
        for nv, nw in edges[v].items() :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
    return dist
    
if __name__ == "__main__" :
    N = int(input())
    M = int(input())
    edges = [dict() for _ in range(N + 1)]
    for _ in range(M) :
        v1, v2, w = map(int, input().split())
        edges[v1][v2] = min(edges[v1][v2], w) if v2 in edges[v1].keys() else w
    v1, v2 = map(int, input().split())
    dist = Dijkstra(v1)
    print(dist[v2])
