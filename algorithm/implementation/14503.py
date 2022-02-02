from sys import stdin
N, M = map(int, stdin.readline().split())
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
X, Y, DIR = map(int , stdin.readline().split())
board = [list(map(int, stdin.readline().split())) for _ in range(N)]
cnt = 0

def clean(X, Y, D):
    global cnt
    if board[X][Y] == 0:
        board[X][Y] = -1
        cnt += 1
    for _ in range(4):
        nd = (D + 1) % 4
        nx = X + dx[nd]
        ny = Y + dy[nd]
        if (0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0):
            clean(nx, ny, nd)
            return
        D = nd
    nx, ny = X - dx[D], Y - dy[D]
    if 0 <= nx < N and 0 <= ny < M:
        if board[nx][ny] == 1:
            print(cnt)
            return
        clean(nx, ny, D)
        
clean(X, Y, DIR)
