from sys import stdin

def dfs(X, Y, total, block) :
    if block == 4 :
        global result
        result = max(result, total)
        return
    elif total + max_block_val * (4 - block) < result :
        return
    for direction in directions :
        nx, ny = X + direction[0], Y + direction[1]
        if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0 :
            if block == 2 :
                visited[nx][ny] = 1
                dfs(X, Y, board[nx][ny] + total, block + 1)
                visited[nx][ny] = 0
            visited[nx][ny] = 1
            dfs(nx, ny, board[nx][ny] + total, block + 1)
            visited[nx][ny] = 0
            
if __name__ == "__main__" :
    N, M = map(int, stdin.readline().split())
    board = [list(map(int, stdin.readline().split())) for _ in range(N)]
    visited = [[0] * M for _ in range(N)]
    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    result = 0
    max_block_val = max(map(max, board))
    for i in range(N) :
        for j in range(M) :
            visited[i][j] = 1
            dfs(i, j, board[i][j], 1)
            visited[i][j] = 0
    print(result)
