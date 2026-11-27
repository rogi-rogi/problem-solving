from sys import setrecursionlimit
setrecursionlimit(int(1e5))

def dfs(x, y) :
    graph[x][y] = -1
    for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0), (-1, -1), (-1, 1), (1, 1), (1, -1)] :
        nx, ny = x + dx, y + dy
        if 0 <= nx < h and 0 <= ny < w :
            if graph[nx][ny] == 1:
                dfs(nx, ny)
    return 1

while True :
    w, h = map(int, input().split())
    if not w : break
    graph = [[*map(int, input().split())] for _ in range(h)]
    cnt = 0
    for i in range(h) :
        for j in range(w) :
            if graph[i][j] == 1:
                cnt += dfs(i, j)
    print(cnt)
