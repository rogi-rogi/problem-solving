from sys import stdin
input = stdin.readline

def FloydWarshall() :
    for t in range(1, N + 1) :
        for v1 in range(1, N + 1) :
            for v2 in range(1, N + 1) :
                if (edges[v1][t] + edges[t][v2]) == 2 : edges[v1][v2] = 1

N = int(input())
edges = [[0] * (N + 1) for _ in range(N + 1)]    
for v1 in range(1, N + 1) :
    for v2, isConnected in enumerate([*map(int, input().split())]) :
        if isConnected : edges[v1][v2 + 1] = 1       
FloydWarshall()
for i in range(1, N + 1) :
    print(*edges[i][1:])
