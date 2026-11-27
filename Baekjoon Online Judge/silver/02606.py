def dfs(n) :
    cnt = 0
    visited[n] = True
    for i in range(2, N + 1) :
        if graph[n][i] and not visited[i] :
            cnt += 1 + dfs(i)
    return cnt

N = int(input())
graph = [[0] * (N + 1) for _ in range(N + 1)]
visited = [False] * (N + 1)
visited[0] = True
for _ in range(int(input())) :
    x, y = map(int, input().split())
    graph[x][y] = graph[y][x] = 1
print(dfs(1))
