from heapq import heapify, heappop, heappush
from sys import stdin
input = stdin.readline

'''
[ Time Complexity ] : O ((V + E) log V) = O (E log V), (dense graph)

target : undirected graph, dense graph
'''

def Prim(v, divide = 1) :
    visited = [False] * (V + 1)
    visited[v] = True
    pq = [(w, v, v2) for v2, w in edges[v].items()]
    heapify(pq)
    MST_weights = []
    connected_edge = 0
    while pq :
        w, v1, v2 = heappop(pq)
        if not visited[v2] :
            visited[v2] = True
            connected_edge += 1
            MST_weights.append(w)
            for nv, nw in edges[v2].items() :
                if not visited[nv] : heappush(pq, (nw, v2, nv))
        if connected_edge >= V - 1 : break
    return sum(MST_weights) - sum(sorted(MST_weights, reverse = True)[:divide - 1])
  
if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = [dict() for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges[v1][v2] = min(edges[v1][v2], w) if v2 in edges[v1].keys() else w
        edges[v2][v1] = min(edges[v2][v1], w) if v1 in edges[v2].keys() else w
    print(Prim(1))
