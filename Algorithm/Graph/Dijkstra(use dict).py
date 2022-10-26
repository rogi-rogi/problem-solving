from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) : # start Vertex
    pq = []
    heappush(pq, (0, v))
    dist[v] = 0
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue
        for nv, nw in graph[v].items() :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
                
if __name__ == "__main__" :
    V, E = map(int, input().split())
    graph = [dict() for _ in range( + 1)] # The edge may not be given for both vertex.
    dist = [inf] * (V + 1)
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        graph[v1][v2] = min(graph[v1][v2], w) if v2 in graph[v1].keys() else w
    Dijkstra(1)
    for i in range(1, V + 1) :
        print([dist[i], "INF"][dist[i] == inf])
