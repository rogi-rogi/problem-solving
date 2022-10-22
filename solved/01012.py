from sys import setrecursionlimit, stdin
input = stdin.readline
setrecursionlimit(int(1e5))

def dfs(x, y) :
    visited[x][y] = True
    for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)] :
        nx, ny = x + dx, y + dy
        if 0 <= nx < N and 0 <= ny < M :
            if graph[nx][ny] and not visited[nx][ny] :
                dfs(nx, ny)

for _ in range(int(input())) :
    M, N, K = map(int, input().split())
    graph = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    location = []
    for _ in range(K) :
        y, x = map(int, input().split())
        graph[x][y] = 1
        location.append((x, y))
    cnt = 0
    for x, y in location :
        if not visited[x][y] :
            dfs(x, y)
            cnt += 1
    print(cnt)
