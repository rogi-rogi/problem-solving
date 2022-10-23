from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) :
    pq = []
    heappush(pq, (0, v))
    dist[v] = 0
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue
        if v == v2 : return
        for nv, nw in graph[v] :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))

if __name__ == "__main__" :
    N = int(input())
    M = int(input())
    graph = [[] for _ in range(N + 1)]
    dist = [inf] * (N + 1)
    for _ in range(M) :
        v1, v2, w = map(int, input().split())
        graph[v1].append((v2, w))
    v1, v2 = map(int, input().split())
    Dijkstra(v1)
    print(dist[v2])
