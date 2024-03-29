# pypy3

from sys import setrecursionlimit, stdin
setrecursionlimit(1002)
input = stdin.readline

def bipartite_matching() :
    match = [0] * SIZE
    visited = None
    
    def dfs(v1) :
        for v2 in graph[v1] :
            if not visited[v2] :
                visited[v2] = True
                if not match[v2] or dfs(match[v2]) :
                    match[v2] = v1
                    return True
        return False
        
    maximum_flow = 0
    MAX = 2 * N
    for _ in range(2) :
        for i in range(1, N + 1) :
            visited = [False] * SIZE
            if dfs(i) :
                maximum_flow += 1
                if maximum_flow == MAX : break
    return maximum_flow

if __name__ == "__main__" :
    N, M = map(int, input().split())
    SIZE = 1001
    graph = [[] for _ in range(N + 1)]
    for v1 in range(1, N + 1) :
        line = [*map(int, input().split())]
        if int(line[0]) >= 1 :
            _, *m = line
            graph[v1] = m
    print(bipartite_matching())
