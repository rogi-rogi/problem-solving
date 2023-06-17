from math import inf
from sys import stdin
input = stdin.readline

'''
[ Time Complexity ] : O (VE)
target : graph with negative cycle
모든 정점에 대해 모든 간선을 전부 확인하면서 모든 정점간 최단거리를 갱신하는 방식.
'''

def bellman_ford(start) :
    dist = [inf] * (V + 1)
    dist[start] = 0
    for start in range(1, V + 1) :
        for u, v, w in graph :
            if dist[u] != inf and dist[u] + w < dist[v] :
                if start == V : return False    # find negative cycle.
                dist[v] = dist[u] + w
    return dist

if __name__ == "__main__" :
    V, E = map(int, input().split())
    graph = [[*map(int, input().split())] for _ in range(E)]
    graph.sort()
    dist = bellman_ford(1)
    if dist : print(*dist[1:])
    else : print(-1)
