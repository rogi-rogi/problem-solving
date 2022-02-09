from collections import deque
from sys import stdin

if __name__ == "__main__" :
    N, M = map(int , stdin.readline().split())
    board = [list(map(int, stdin.readline().split())) for _ in range(N)]
    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    sec = 0
    row = [0, N]
    col = [0, M]
    while True :
        before_cheese = 0
        for i in range(N) :
            for j in range(M) :
                if board[i][j] == -1:
                    board[i][j] = 0
                before_cheese += 1
        cheese = before_cheese
        airs = deque([(row[0], col[0])])
        visited = [[0] * col[0] for _ in range(row[0])]
        t_row = list(reversed(row))
        t_col = list(reversed(col))
        while airs :
            x, y = airs.popleft()
            for dx, dy in directions :
                nx = x + dx
                ny = y + dy
                if row[0] <= nx < row[1] and col[0] <= ny < col[1] :
                    if board[nx][ny] == 0 : airs.append((nx, ny))
                    else :
                        board[nx][ny] = -1
                        cheese -= 1
                        t_row[0] = min(t_row[0], nx)
                        t_row[1] = max(t_row[1], nx + 1)
                        t_col[0] = min(t_col[0], ny)
                        t_col[1] = max(t_col[1], ny + 1)
        sec += 1
        if cheese == 0 :
            print(sec, before_cheese, sep = '\n')
            break
        for i in range(t_row[0], t_row[1]) :
            for j in range(t_col[0], t_col[1]) :
                if board[i][j] == -1 :
                    board[i][j] = 0
