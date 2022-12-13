from sys import setrecursionlimit, stdin
setrecursionlimit(10**4)
input = stdin.readline

def DFS(v) :
    if visited[v] : return 1
    visited[v] = True
    return DFS(edges[v])

for _ in range(int(input())) :
    N = int(input())
    edges = [0] + [*map(int, input().split())]
    visited = [False] * (N + 1)
    print(sum(DFS(i) for i in range(1, N + 1) if not visited[i]))
