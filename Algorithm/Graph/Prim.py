from heapq import heappop, heappush, heapify
from sys import stdin
input = stdin.readline

'''
[ Time Complexity ]


target : DAG(Directed Acyclic Graph), graph with dense edges

[ MST(Minimum Spanning Tree) ]
tree containing all vertex of the graph
this is the graph of the least connected subgraph
for 'V' vertex, have at least 'V - 1' minimum edge

'''

def Pime(v) :
  visited = [False] * (V + 1)
  visited[v] = True
  # pq <<< edges[v]
  heapify(pq)
  MST = []    # Minimum Spanning Tree
  MST_weight = 0
  while pq :
    # w, v1, v2 = heappop(pq)
    if not visited[v2] :
      visited[v2] = True
      MST_weight += w
      MST.append((v1, v2))
      for e in edges[v2] :
        if not visited[e[2]]) : heappush(pq, e)
  return MST, MST_weight

if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = [dict() for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        # append (w, v1, v2) ?
    Prim(1)
