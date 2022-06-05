from collections import deque

def bfs(x, y, water) :
    queue = deque([(x, y)])
    while queue :
        x, y = queue.popleft()
        for dx, dy in [(1, 0), (0, 1), (-1, 0), (0, -1)] :
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N :
                if not visited[nx][ny] and graph[nx][ny] > water :
                    visited[nx][ny] = True
                    queue.append((nx, ny))
    return 1

N = int(input())
graph = [[*map(int, input().split())] for _ in range(N)]
water_height = []
for i in range(N) :
    water_height += graph[i]
res = 1
for h in [*set(water_height)] :
    visited = [[False] * N for _ in range(N)]
    cnt = 0
    for i in range(N) :
        for j in range(N) :
            if not visited[i][j] and graph[i][j] > h :
                cnt += bfs(i, j, h)
    res = max(res, cnt)
print(res)
