'''
[ Time Complexity ] : O (VE)
모든 정점(V - 1 + 1)에 대해 모든 간선(E)을 전부 확인하면서 모든 정점 간 최단거리를 갱신하는 방식.

최단 경로는 최대 V - 1 개의 간선을 가진다.
따라서, V - 1 번의 모든 정점에 대한 탐색이 이루어져야 모든 정점에 대한 최단경로를 구할 수 있다.

그 이후 동일한 탐색과정을 한 번 더 실행했을 때, 만약 최단 거리가 갱신된다면 음수 사이클이 존재한다는 것이다.
'''

'''
def bellman_ford(start) :
    dist = [inf] * (V + 1)
    dist[start] = 0

    # 1 ~ (V - 1) : 최단 거리 갱신과정.
    # V : 음수 사이클 확인과정
    for cycle in range(1, V + 1) :
        for u, v, w in graph :
            if dist[u] != inf and dist[u] + w < dist[v] :
                if cycle == V : raise ValueError("find negative cycle")
                dist[v] = dist[u] + w
    return dist
'''
from math import inf
from sys import stdin
input = stdin.readline

def bellman_ford(start):
    dist = [inf] * (V + 1)
    dist[start] = 0
    
    # 최단 거리 갱신
    for _ in range(V - 1) :
        for u, v, w in graph :
            # dist[u] != inf : 이미 갱신이 된 정점에 대해서만 갱신을 진행한다.
            # inf의 연산 오류를 방지하기 위함(inf - 1 = inf)
            if dist[u] != inf and dist[u] + w < dist[v] :
                dist[v] = u + w
                
    # 갱신된 최단거리에 대해 한번 더 최단거리가 발견되는지(음수 사이클이 존재하는지) 확인
    for u, v, w in edges:
        if dist[u] + w < dist[v]:
            raise ValueError("find negative cycle")
    return dist

if __name__ == "__main__" :
    V, E = map(int, input().split())
    # graph = [[*map(int, input().split())] for _ in range(E)]
    for _ in range(E) :
        u, v, w = map(int, input().split())
        graph.append((u, v, w))
        
    dist = bellman_ford(1)
    if dist : print(*dist[1:])
    else : print(-1)
