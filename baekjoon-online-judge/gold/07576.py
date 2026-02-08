from heapq import heappop, heappush
from collections import deque
from sys import stdin

input = stdin.readline

D = [(0, 1), (0, -1), (1, 0), (-1, 0)]
def bfs():
    queue = deque([])
    empty_cnt = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                queue.append((i, j))
            elif graph[i][j] == -1:
                empty_cnt += 1
    if len(queue) + empty_cnt == N * M:
        return 0
    day = -1
    same_level = 0
    cnt = len(queue)
    while queue:
        if same_level == 0:
            same_level = len(queue)
            day += 1
        x, y = queue.popleft()
        for dx, dy in D:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 0:
                cnt += 1
                graph[nx][ny] = 1
                queue.append((nx, ny))
        same_level -= 1
    return day if cnt + empty_cnt == N * M else -1

if __name__ == '__main__':
    # Input
    M, N = map(int, input().split())
    graph = [[*map(int, input().split())] for _ in range(N)]

    # Solve & Output
    print(bfs())