from math import inf
from sys import stdin
input = stdin.readline

def FloydWarshall() :
    for v1 in range(V + 1) :
        for v2 in range(V + 1) :
            if edges[v1][v2] != inf : continue 
            for t in range(V + 1) :
                if edges[v1][t] == edges[t][v2] and edges[t][v2] != inf :
                    edges[v1][v2] = edges[v1][t]
                    edges[v2][v1] = -edges[v1][t]
                    # finds a new edge connected between two unconnected vertices.
                    break

if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = [[inf] * (V + 1) for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2 = map(int, input().split())
        edges[v1][v2] = 1
        edges[v2][v1] = -1
    for v in range(1, V + 1) :
        edges[v][v] = 0
    FloydWarshall()
    cnt = 0
    for v1 in range(1, V + 1) :
        for v2 in range(1, V + 1) :
            if edges[v1][v2] == inf : break
        else : cnt += 1
    print(cnt)
