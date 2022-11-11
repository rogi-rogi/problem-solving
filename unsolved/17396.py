from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) :
    dist = [inf] * (N + 1)
    dist[v] = 0
    pq = []
    heappush(pq, (0, v))
    while pq :
        w, v = heappop(pq)
        if v == N - 1 : return dist
        if dist[v] < w : continue
        for nv, nw in graph[v] :
            nw += w
            if nw < dist[nv] and not is_view[nv]:
                dist[nv] = nw
                heappush(pq, (nw, nv))
    return dist

if __name__ == "__main__" :
    N, M = map(int, input().split())
    is_view = [*map(int, input().split())]
    is_view[-1] = 0
    graph = [[] for _ in range(N + 1)]
    for _ in range(M) :
        a, b, t = map(int, input().split())
        graph[a].append((b, t))
        graph[b].append((a, t))
    dist = Dijkstra(0)
    print([dist[N - 1], -1][dist[N - 1] == inf])
