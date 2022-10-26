from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) :
    pq =[]
    heappush(pq, (0, v))
    dist[v] = 0
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue
        if v == N : return
        for nv, nw in graph[v] :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))

if __name__ == "__main__" :
    N, M = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    dist = [inf] * (N + 1)
    for _ in range(M) :
        A_i, B_i, C_i = map(int, input().split())
        graph[A_i].append((B_i, C_i))
        graph[B_i].append((A_i, C_i))
    Dijkstra(1)
    print(dist[N])
        
