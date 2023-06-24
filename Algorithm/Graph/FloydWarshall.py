from math import inf
from sys import stdin
input = stdin.readline

'''
[ Time Complexity ] : O(V^3)

edges[v1][v2]  vs  edges[v1][t] + edges[t][v2]

모든 정점에 대해 모든 정점까지의 최단거리를 구하기 위해 사용하며,
음수 사이클이 없고, 양/음 가중치를 가지는 그래프에서 사용하는 알고리즘
'''

def floyd_warshall() :
    for t in range(1, V + 1) :
        for u in range(1, V + 1) :
            for v in range(1, V + 1) :
                if u == v : continue
                w = graph[u][t] + graph[t][v]
                if graph[u][v] > w : graph[u][v] = w

if __name__ == "__main__" :
    V, E = map(int, input().split())
    graph = [[inf] * (V + 1) for _ in range(V + 1)]
    # init 
    for u in range(1, V + 1) :
        graph[u][u] = 0
    
    # input
    for _ in range(E) :
        u, v, w = map(int, input().split())
        # 동일한 길에 대해 가중치가 더 큰 길은 입력받을 필요가 없다.
        if graph[u][v] > w : graph[u][v] = w
        
    floyd_warshall()
    
    # output
    for u in range(1, V + 1) :
        print(*["%3d" % graph[u][v] for v in range(1, V + 1)])
