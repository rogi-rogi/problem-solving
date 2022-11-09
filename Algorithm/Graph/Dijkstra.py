from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

'''
[ Time Complexity ] : O((V + E) log V)
find the shortest distance node : O (V log V)
update the shortest distance of the node : O (E log V)

target : DAG(Directed Acyclic Graph) / cycle graph with positive weight

if no negative cycle, but has a negative weight, can get the shortest distance.
but, it takes a long time.
'''

def Dijkstra(v) : # start Vertex
    pq = []
    heappush(pq, (0, v))
    dist[v] = 0
    while pq :
        w, v = heappop(pq)
        if dist[v] < w : continue # distance previously calculated is shorter
        for nv, nw in graph[v] :
            nw += w
            if nw < dist[nv] :
                dist[nv] = nw
                heappush(pq, (nw, nv))
                
if __name__ == "__main__" :
    V, E = map(int, input().split())
    graph = [[] for _ in range(V + 1)]
    dist = [inf] * (V + 1)
    for _ in range(E) :
        v1, v2, w = map(int, input().split())  # v1 --(w)--> v2 
        graph[v1].append((v2, w))
    Dijkstra(1)
    print(*dist[1:])
