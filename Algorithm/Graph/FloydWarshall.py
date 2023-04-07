from math import inf
from sys import stdin
input = stdin.readline

'''
[ Time Complexity ] : O(V^3)

edges[v1][v2]  vs  edges[v1][t] + edges[t][v2]

target : 양의 가중치를 갖는 순환 그래프, 음의 가중치를 가지는 비순환 그래프 
모든 노드에 대한 최단 거리를 구할 때
음의 가중치에 대해서는 자기 자신을 가리키는 가중치가 0보다 작은지를 판별해 음수 사이클을 벗어나야 한다.
ex) (v1, v1) = 0 일 때, v1 -> v2 -> v3 < 0 인 경우 (v1, ..., v1) < 0 이 되므로 음수 사이클이 존재한다.  
'''

def FloydWarshall() :
    for t in range(1, V + 1) :
        for v1 in range(1, V + 1) :
            for v2 in range(1, V + 1) :
                if v1 == v2 : edges[v1][v2] = 0 
                w = edges[v1][t] + edges[t][v2]
                if edges[v1][v2] > w : edges[v1][v2] = w

if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = [[inf] * (V + 1) for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        if edges[v1][v2] > w : edges[v1][v2] = w
    FloydWarshall()
    for v1 in range(1, V + 1) :
        print(*[edges[v1][v2] for v2 in range(1, V + 1) if edges[v1][v2] != inf])
        
