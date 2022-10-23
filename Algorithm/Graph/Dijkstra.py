from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) : # start V 
    pq = []
    heappush(pq, (0, v))
    dist[v] = 0
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue # distance previously calculated is shorter
        for nv, nw in graph[v] :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
                
if __name__ == "__main__" :
    V, E = map(int, input().split())
    graph = [[] for _ in range(V + 1)]
    dist = [inf] * (V + 1)
    for _ in range(E) :
        v1, v2, w = map(int, input().split())  # v1 --(w)--> v2
        graph[v1].append((v2, w))
    Dijkstra(1)
    for i in range(1, V + 1) :
        print([dist[i], "INF"][dist[i] == inf])
