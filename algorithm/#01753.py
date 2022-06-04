from heapq import heappop, heappush
from sys import stdin
input = stdin.readline

def dijkstra(v):
    pq = []
    heappush(pq, (0, v))
    dist[v] = 0
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue
        for nv, nw in graph[v] :
            nw = w + nw
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
                
if __name__ == "__main__" :
    INF = int(int(3e7) + 1)
    V, E = map(int, input().split())
    K = int(input())
    graph = [[] * (V + 1) for _ in range(V + 1)]
    dist = [INF] * (V + 1)
    for _ in range(E):
        u, v, w = map(int, input().split()) # u -(w)-> v
        graph[u].append((v, w))
    dijkstra(K)
    for i in range(1, V + 1):
        print("INF" if dist[i] == INF else dist[i])
