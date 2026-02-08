def dfs(x, y) :
    if graph[x][y] == -1 :
        print("HaruHaru")
        exit(0)
    visited[x][y] = True
    for dx, dy in [(1, 0), (0, 1)] :
        nx = x + dx * graph[x][y]
        ny = y + dy * graph[x][y]
        if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] :
            dfs(nx, ny)
    
N = int(input())
graph = [[*map(int, input().split())] for _ in range(N)]
visited = [[False] * N for _ in range(N)]
dfs(0, 0)
print("Hing") 
