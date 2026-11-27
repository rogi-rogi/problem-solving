from collections import deque

def bfs(x, y, mode = 0) :
    queue = deque([(x, y)])
    visited[x][y] = True
    while queue :
        x, y = queue.popleft()
        for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)] :
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] :
                if board[nx][ny] == board[x][y] :
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                elif mode == 1 and board[x][y] != 'B' and board[nx][ny] != 'B':
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    
if __name__ == "__main__" :
    N = int(input())
    board = [[*input()] for _ in range(N)]
    visited = [[False] * N for _ in range(N)]
    color_weakness = 0
    un_color_weakness = 0
    for i in range(N) :
        for j in range(N) :
            if not visited[i][j] :
                bfs(i, j)
                color_weakness += 1
            
    visited = [[False] * N for _ in range(N)]
    for i in range(N) :
        for j in range(N) :
            if not visited[i][j] :
                bfs(i, j, 1)
                un_color_weakness += 1
    print(color_weakness, un_color_weakness)
