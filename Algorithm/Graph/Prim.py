from heapq import heappop, heappush
from sys import stdin
input = stdin.readline

'''
[ Time Complexity ] : O (E log V)

target : 유향 비순환 그래프(DAG :Directed Acyclic Graph), dense graph

최소 신장 트리(MST : Minimum Spanning Tree)를 찾기 위한 알고리즘이다.  


[ 신장트리 : Spanning Tree ]
그래프의 모든 정점을 포함하는 트리이다. (=최소 연결 부분 그래프)
N개의 정점에 대해 최소 N - 1개의 간선을 가지며, 사이클을 포함해서는 안된다.
'''

def Prim(v) :
    visited = [False] * (V + 1)
    visited[v] = True
    pq = []
    for v2, w in edges[v].items() : heappush(pq, (w, v, v2))
    MST = []    # Minimum Spanning Tree
    MST_weight = 0
    while pq :
      w, v1, v2 = heappop(pq)
      if not visited[v2] :
        visited[v2] = True
        MST_weight += w
        MST.append((v1, v2))
        #for e in edges[v2].items() :
          #if not visited[e[2]] : heappush(pq, e + )
    return MST, MST_weight
  
if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = [dict() for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges[v1][v2] = min(edges[v1][v2], w) if v2 in edges[v1].keys() else w
        edges[v2][v1] = min(edges[v2][v1], w) if v1 in edges[v2].keys() else w
    Prim(1)
