from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

'''
[ Time Complexity ] : O((V + E) log V)
최단 거리의 정점을 찾는시간    : O (V log V)
최단 거리를 업데이트 하는 시간 : O (E log V)

target : 유향 비순환 그래프(DAG :Directed Acyclic Graph), 양의 가중치를 갖는 순환 그래프

음의 가중치를 갖는 순환이 없을 경우, 음의 가중치를 가지는 간선이 포함되어 있어도 구할 수 있다.
하지만, 상대적으로 많은 시간이 걸린다.
'''

def Dijkstra(v) : # start Vertex
    dist = [inf] * (V + 1)
    dist[v] = 0
    pq = []
    heappush(pq, (0, v))
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue # distance previously calculated is shorter
        # for nv, nw in edges[v] :
        for nv, nw in edges[v].items() : 
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
    return dist
                
if __name__ == "__main__" :
    V, E = map(int, input().split())
    # edges = [[] for _ in range(V + 1)]  
    edges = [dict() for _ in range(V + 1)] # The edge may not be given for both vertex.
    for _ in range(E) :
        v1, v2, w = map(int, input().split())  # v1 --(w)--> v2
        # edges[v1].append((v2, w))
        edges[v1][v2] = min(edges[v1][v2], w) if v2 in edges[v1].keys() else w
        edges[v2][v1] = min(edges[v2][v1], w) if v1 in edges[v2].keys() else w 
    dist = Dijkstra(1)
    print(*dist[1:])
