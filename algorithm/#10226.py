from collections import deque

def bfs(x, y, mode = 0) :
    area = deque([(x, y)])
    visited[x][y] = 1
    while area :
        x, y = area.popleft()
        for dx, dy in directions :
            nx = x + dx
            ny = y + dy
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == 0:
                if board[nx][ny] == board[x][y] :
                    visited[nx][ny] = 1
                    area.append((nx, ny))
                elif mode == 1 and board[x][y] != 'B' and board[nx][ny] != 'B':
                    visited[nx][ny] = 1
                    area.append((nx, ny))
                    
if __name__ == "__main__" :
    N = int(input())
    board = [list(input()) for _ in range(N)]
    visited = [[0] * N for _ in range(N)]
    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    color_weakness = 0
    un_color_weakness = 0
    for i in range(N) :
        for j in range(N) :
            if visited[i][j] == 0 :
                bfs(i, j)
                color_weakness += 1
    visited = [[0] * N for _ in range(N)]
    for i in range(N) :
        for j in range(N) :
            if visited[i][j] == 0 :
                bfs(i, j, 1)
                un_color_weakness += 1
    print(color_weakness, un_color_weakness)
