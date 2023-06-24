from math import inf
from sys import stdin
input = stdin.readline

def floyd_warshall() :
    for t in range(1, N + 1) :
        for u in range(1, N + 1) :
            for v in range(1, N + 1) :
                if u == v : continue
                if graph[u][t] + graph[t][v] != inf :
                    graph[u][v] = 1

if __name__ == "__main__" :
    N, M = map(int, input().split())
    graph = [[inf] * (N + 1) for _ in range(N + 1)]
    
    for u in range(1, N + 1) :
        graph[u][u] = 0
        
    for _ in range(M) :
        a, b = map(int, input().split())
        graph[a][b] = 1
        
    floyd_warshall()
    
    cnt = 0
    for u in range(1, N + 1) :
        for v in range(1, N + 1) :
            if u != v and graph[u][v] == inf and graph[v][u] == inf : break
        else : cnt += 1
    print(cnt)
