from sys import setrecursionlimit, stdin
input = stdin.readline
setrecursionlimit(int(1e5))

def dfs(n) :
    visited[n] = True
    for i in range(1, N + 1) :
        if graph[n][i] and not visited[i] :
            dfs(i)
    return 1

N, M = map(int, input().split())
graph = [[0] * (N + 1) for _ in range(N + 1)]
visited = [False] * (N + 1)
for _ in range(M) :
    x, y = map(int, input().split())
    graph[x][y] = graph[y][x] = 1
cnt = 0
for i in range(1, N + 1) :
    if not visited[i] :
        cnt += dfs(i)
print(cnt)
