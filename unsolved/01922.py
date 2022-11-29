from heapq import heappop, heappush
from sys import stdin
input = stdin.readline

def Prim(v) :
    visited = [False] * (V + 1)
    visited[v] = True
    pq = []
    for v2, w in edges[v].items() : heappush(pq, (w, v, v2))
    MST_weight = 0
    while pq :
        w, v1, v2 = heappop(pq)
        if not visited[v2] :
            visited[v2] = True
            MST_weight += w
            for nv, nw in edges[v2].items() :
                if not visited[nv] : heappush(pq, (nw, v2, nv))
    return MST_weight
  
if __name__ == "__main__" :
    V = int(input())
    E = int(input())
    edges = [dict() for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges[v1][v2] = min(edges[v1][v2], w) if v2 in edges[v1].keys() else w
        edges[v2][v1] = min(edges[v2][v1], w) if v1 in edges[v2].keys() else w
    print(Prim(1))
