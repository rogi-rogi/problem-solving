from collections import deque
from sys import stdin

if __name__ == "__main__" :
    N = int(stdin.readline())
    K = int(stdin.readline())
    board = [[0] * N for _ in range(N)]
    for _ in range(K) :
        x, y = map(int, stdin.readline().split())
        board[x - 1][y - 1] = 1
    L = int(stdin.readline())
    turns = dict()
    for _ in range(L) :
        X, C = stdin.readline().split()
        turns[int(X)] = C
        
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    direction = 1
    sec = 1
    x = y = 0
    visited = deque([[x,y]])
    board[x][y] = -1
    while True :
        x = x + dx[direction]
        y = y + dy[direction]
        if 0 <= x < N and 0 <= y < N and board[x][y] != -1 :
            if board[x][y] == 0 :
                tail_x, tail_y = visited.popleft()
                board[tail_x][tail_y] = 0
            board[x][y] = -1
            visited.append([x,y])
            if sec in turns.keys() :
                direction = (direction + 3) % 4 if turns[sec] == 'L' else (direction + 1) % 4
            sec += 1
        else :
            print(sec)
            break
