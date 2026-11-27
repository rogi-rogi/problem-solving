from collections import deque
from sys import stdin

def bfs() :
    visited = [[0] *  M for _ in range(N)]
    visited[ices[0][0]][ices[0][1]] = 1
    lump = deque([ices[0]])
    ice_cnt = 0
    while lump :
        around_cnt = 0
        ice_cnt += 1
        x, y = lump.popleft()
        for direction in directions :
            nx = x + direction[0]
            ny = y + direction[1]
            if visited[nx][ny] == 0:
                if board[nx][ny] == 0 :
                    around_cnt += 1
                elif board[nx][ny] > 0 :
                    visited[nx][ny] = 1
                    lump.append((nx, ny))
        board[x][y] -= around_cnt if board[x][y] - around_cnt != 0 else (around_cnt + 1)
    return ice_cnt
    
if __name__ == "__main__" :
    N, M = map(int, stdin.readline().split())
    board = [list(map(int, stdin.readline().split())) for _ in range(N)]
    directions = [(-1, 0,), (0, 1), (1, 0), (0, -1)]
    ices = ([ (i, j) for i in range(N) for j in range(M) if board[i][j] != 0 ])
    year = 0
    while True :
        next_ices = []
        if len(ices) == 0 :
            year = 0
            break  
        if bfs() != len(ices) :
            break
        for x, y in ices :
            if board[x][y] < 0 :
                board[x][y] = 0
            else :
                next_ices.append((x, y))
        ices = next_ices[:]
        year += 1
    print(year)
