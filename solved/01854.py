from heapq import heappop, heappush
from math import inf
from sys import stdin

input = stdin.readline

def Dijkstra(v) :
    dists = [[inf] * K for _ in range(V + 1)]   # V(1~V)개의 노드에 대해 K(1~K)번째의 최단거리를 저장
    dists[v][0] = 0
    pq = [(0, v)]
    while pq :
        w, v = heappop(pq)
        if dists[v][-1] < w : continue
        for nv, nw in edges[v] :
            nw += w
            if nw < dists[nv][-1] :
                dists[nv][-1] = nw
                dists[nv].sort()
                heappush(pq, (nw, nv))
    return dists

if __name__ == "__main__" :
    V, E, K = map(int, input().split())
    edges = [[] for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges[v1].append((v2, w))
    dists = Dijkstra(1)
    for i in range(1, V + 1) :
        print(-1 if dists[i][-1] == inf else dists[i][-1])
