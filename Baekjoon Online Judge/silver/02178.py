from collections import deque
from sys import stdin

input = stdin.readline

D = [(0, 1), (0, -1), (1, 0), (-1, 0)]
def bfs(N, M):
    queue = deque([(0, 0)])
    board[0][0] = 2
    while queue:
        x, y = queue.popleft()
        if x == N and y == M:
            return board[x][y] - 1
        for dx, dy in D:
            nx, ny = x + dx, y + dy
            if is_valid(nx, ny):
                board[nx][ny] = board[x][y] + 1
                queue.append((nx, ny))

def is_valid(x, y):
    return 0 <= x < N and 0 <= y < M and board[x][y] == 1

if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())
    board = [[*map(int, input().rstrip())] for _ in range(N)]

    # Solve & Output
    print(bfs(N - 1, M - 1))
