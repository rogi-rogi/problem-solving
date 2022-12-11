from math import inf
from sys import stdin
input = stdin.readline

def FloydWarshall() :
    for t in range(1, V + 1) :
        for v1 in range(1, V + 1) :
            for v2 in range(1, V + 1) :
                w = edges[v1][t] + edges[t][v2]
                if edges[v1][v2] > w :
                    edges[v1][v2] = w

if __name__ == "__main__" :
    V = int(input())
    E = int(input())
    edges = [[inf] * (V + 1) for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        if edges[v1][v2] > w : edges[v1][v2] = w
    FloydWarshall()
    del edges[0]
    for edge in edges :
        del edge[0]
        for e in edge :
            print([e, 0][e == inf], end = ' ')
        print()
