from math import inf
from sys import stdin
input = stdin.readline

def FloydWarshall() :
    for t in range(V + 1) :
        for v1 in range(V + 1) :
            for v2 in range(V + 1) :
                w = edges[v1][t] + edges[t][v2]
                if edges[v1][v2] > w : edges[v1][v2] = w

if __name__ == "__main__" :
    V = int(input())
    E = int(input())
    edges = [[inf] * (V + 1) for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2 = map(int, input().split())
        edges[v1][v2] = 1
    FloydWarshall()
    for v1 in range(1, V + 1) :
        print(sum(1 for v2 in range(1, V + 1) if (v1 != v2 and edges[v1][v2] == inf and edges[v2][v1] == inf)))
