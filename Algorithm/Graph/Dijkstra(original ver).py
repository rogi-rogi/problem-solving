from math import inf
from sys import stdin
input = stdin.readline

# O(V^2)
def Dijkstra(v) :
    dist = [inf] * (V + 1)
    dist[v] = 0
    visited = [False] * (V + 1)
    visited[v] = True
    for av, aw in edges[v] : # vertex adjacent to the start vertex
        dist[av] = aw
    for _ in range(V - 1) :  # other vertex
        min_weighted = inf
        nv = 0               # get adjacent vertex with low weights
        for av in range(1, V + 1) :
            if not visited[av] and dist[av] < min_weighted :
                min_weighted = dist[av]
                nv = av
        visited[nv] = True
        for av, aw in edges[nv] :
            nw = dist[nv] + aw
            if nw < dist[av] :
                dist[av] = nw
    return dist
                
if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = [[] for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges[v1].append((v2, w))
    dist = Dijkstra(1)
    print(*dist[1:])
