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
        if v == t : return
        if dist[v] < w : continue
        for nv, nw in graph[v] :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))

if __name__ == "__main__" :
    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]
    dist = [inf] * (n + 1)
    for _ in range(m) :
        a, b, c = map(int, input().split())
        graph[a].append((b, c))
        graph[b].append((a, c))
    s, t = map(int, input().split())
    Dijkstra(s)
    print(dist[t])
