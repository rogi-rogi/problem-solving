from collections import deque
from sys import stdin
input = stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
WALL, EMPTY, FIRE, MY = ['#', '.', 'F', 'J']

def bfs() :
    x, y = -1, -1
    queue = deque([])
    for i in range(R) :
        for j in range(C) :
            if board[i][j] == MY :
                x, y = i, j
            elif board[i][j] == FIRE :
                queue.append((FIRE, i, j))
    queue.append((0, x, y))
    
    while queue :
        who, x, y = queue.popleft()
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < R and 0 <= ny < C :
                if board[nx][ny] != FIRE and board[nx][ny] != WALL :
                    if who == FIRE :
                        board[nx][ny] = FIRE
                        queue.append((FIRE, nx, ny))
                    elif board[nx][ny] == EMPTY :
                        board[nx][ny] = MY
                        queue.append((who + 1, nx, ny))
            elif who != FIRE :
                return who + 1
    return "IMPOSSIBLE"

if __name__ == "__main__" :
    R, C = map(int, input().split())
    board = [[*input().rstrip()] for _ in range(R)]
    path = [[0] * C for _ in range(R)]
    print(bfs())
