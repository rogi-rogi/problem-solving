from collections import deque
from sys import stdin

if __name__ == "__main__" :
    N, M = map(int , stdin.readline().split())
    board = [list(map(int, stdin.readline().split())) for _ in range(N)]
    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    sec = 0
    before_cheese = []   
    while True :
        melt = 0
        airs = deque([(0, 0)])
        visited = [[0] * M for _ in range(N)]
        visited[0][0] = 1
        while airs :
            x, y = airs.popleft()
            for dx, dy in directions :
                nx = x + dx
                ny = y + dy
                if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0:
                    if board[nx][ny] == 0 :
                        visited[nx][ny] = 1
                        airs.append((nx, ny))
                    elif board[nx][ny] == 1 :
                        visited[nx][ny] = 1
                        board[nx][ny] = 0
                        melt += 1
        before_cheese.append(melt)
        if melt == 0 :
            print(sec, before_cheese[-2], sep = '\n')
            break
        sec += 1
