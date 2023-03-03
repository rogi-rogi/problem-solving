#pypy3

from sys import setrecursionlimit, stdin
setrecursionlimit(1002)
input = stdin.readline

def BipartiteMatching() :
    def DFS(v1) :
        for v2 in edges[v1] :
            if connected[v2] : continue
            connected[v2] = True
            if not path[v2] or DFS(path[v2]) :
                path[v2] = v1
                return True
        return False
        
    maximum_flow = 0
    connected = None
    path = [0] * (Y + 1)
    for _ in range(2) :
        for i in range(1, X + 1) :
            connected = [False] * (Y + 1)
            if DFS(i) : maximum_flow += 1
    return maximum_flow

if __name__ == "__main__" :
    X, Y = map(int, input().split())
    edges = [[] for _ in range(X + 1)]
    for v1 in range(1, X + 1) :
        for v2 in [*map(int, input().split())][1:] :
            edges[v1].append(v2)
    print(BipartiteMatching())
