#pypy3

from sys import stdin
input = stdin.readline

def BipartiteMatching() :
    def DFS(v1) :
        for v2 in edges[v1] :
            if visited[v2] : continue
            visited[v2] = True
            if not connected[v2] or DFS(connected[v2]) :
                connected[v2] = v1
                return True
        return False
        
    maximum_flow = 0
    visited = None
    connected = [0] * (M + 1)
    for _ in range(2) :
        for i in range(1, N + 1) :
            visited = [False] * (M + 1)
            if DFS(i) :
                maximum_flow += 1
                if maximum_flow == M : break
    return maximum_flow

if __name__ == "__main__" :
    N, M = map(int, input().split())
    edges = [[] for _ in range(N + 1)]
    for v1 in range(1, N + 1) :
        line = [*map(int, input().split())]
        if int(line[0]) >= 1 :
            _, *m = line
            edges[v1] = m
    print(BipartiteMatching())
