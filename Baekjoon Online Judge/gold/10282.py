from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

def Dijkstra(v) :
    dist = [inf] * (V + 1)
    dist[v] = 0
    pq = [(0, v)]
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue
        for nv, nw in edges[v] :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
    return dist
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        V, E, S = map(int, input().split())
        edges = [[] for _ in range(V + 1)]
        for _ in range(E) :
            v1, v2, w = map(int, input().split())
            edges[v2].append((v1, w))
        dist = Dijkstra(S)
        connected_vertex_cnt, infection_time = 0, 0
        for d in dist :
            if d != inf :
                connected_vertex_cnt += 1
                infection_time = max(infection_time, d)
        print(connected_vertex_cnt, infection_time)
                
