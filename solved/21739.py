from collections import deque
from sys import stdin
input = stdin.readline

def BFS(sx, sy) :
    visited = [[False] * M for _ in range(N)]
    visited[sx][sy] = True
    queue = deque([(sx, sy)])
    meet = 0
    while queue :
        x, y = queue.popleft()
        for nx, ny in [(x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)] :
            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] != 'X' and not visited[nx][ny] :
                visited[nx][ny] = True
                queue.append((nx, ny))
                if board[nx][ny] == 'P' :
                    meet += 1
    return ['TT', meet] [meet > 0]

N, M = map(int, input().split())
board = [[] for _ in range(N)]
sx, sy = -1, -1
for i in range(N) :
    board[i] = [*input()]
    for j in range(M) :
        if board[i][j] == 'I' :
            sx, sy = i, j
print(BFS(sx, sy))
