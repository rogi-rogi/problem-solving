# pypy3
from sys import setrecursionlimit, stdin
setrecursionlimit(1002)
input = stdin.readline

def BipartiteMatching() :
    def DFS(v1) :
        visited[v1] = True
        for v2 in edges[v1] :
            if not connected[v2] or DFS(connected[v2]) :
                connected[v2] = v1
                return True
        return False
    maximum_flow = 0
    visited = None
    connected = [0] * (M + 1)
    for i in range(1, N + 1) :
        visited = [False] * (N+ 1)
        if DFS(i) :
            maximum_flow += 1
            if maximum_flow == M : break
    if K > 0 : 
        k = 0
        for i in range(1, N + 1) :
            visited = [False] * (N + 1)
            if DFS(i) :
                maximum_flow += 1
                k += 1
                if k == K : break
    return maximum_flow

if __name__ == "__main__" :
    N, M, K = map(int, input().split())
    edges = [[] for _ in range(N + 1)]
    for v1 in range(1, N + 1) :
        _, *m = map(int, input().split())
        edges[v1] = m
    print(BipartiteMatching())
