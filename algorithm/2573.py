from collections import deque
from sys import stdin

def bfs(X, Y) :
    visited = [[0]*M for _ in range(N)]
    ices = deque([(X,Y)])
    ice_cnt = 1
    while ices :
        x, y = ices.popleft()
        visited[x][y] = 1
        for direction in directions :
            nx = x + direction[0]
            ny = y + direction[1]
            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] != 0 and visited[nx][ny] == 0:
                visited[nx][ny] = 1
                ices.append((nx, ny))
                ice_cnt += 1
    return ice_cnt
    
if __name__ == "__main__" :
    N, M = map(int, stdin.readline().split())
    board = [list(map(int, stdin.readline().split())) for _ in range(N)]
    directions = [(-1, 0,), (0, 1), (1, 0), (0, -1)]
    ices = deque([ (i,j,board[i][j]) for i in range(N) for j in range(M) if board[i][j] != 0 ])
    year = 0
    while True :
        year += 1
        for _ in range(len(ices)) :
            x , y, layer = ices.popleft()
            for direction in directions :
                nx = x + direction[0]
                ny = y + direction[1]
                if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 :
                    layer -= 1
            ices.append((x, y, layer))      
        
        for _ in range(len(ices)) :
            x, y, layer = ices.popleft()
            board[x][y] = layer if layer > 0 else 0
            if layer > 0 :
                ices.append((x, y, layer))
        if len(ices) == 0 :
            print(0)
            break
        elif bfs(ices[0][0], ices[0][1]) != len(ices) :
            print(year)
            break
