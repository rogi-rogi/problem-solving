def dfs(x, y) :
    visited[x][y] = True
    for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)] :
        nx, ny = x + dx, y + dy
        if 0 <= nx < R and 0 <= ny < C :
            if not visited[nx][ny] and graph[nx][ny] == '#' :
                dfs(nx, ny)

R, C = map(int, input().split())
graph = [[*input()] for _ in range(R)]
visited = [[False] * C for _ in range(R)]
cnt = 0
for i in range(R) :
    for j in range(C) :
        if graph[i][j] == '#' and not visited[i][j]:
            dfs(i, j)
            cnt += 1
print(cnt)
