from sys import stdin
input = stdin.readline

def isInArea(x, y) :
    return (0 <= x < N and 0 <= y < M)

def _dfs(x, y, nx, ny, total, block) :
    visited[nx][ny] = 1
    dfs(x, y, total, block)
    visited[nx][ny] = 0
    
def dfs(x, y, total, block) :
    if block == 4 :
        global result
        result = max(result, total)
    elif total + max_block_val * (4 - block) >= result :
        for d in [(-1, 0), (0, 1), (1, 0), (0, -1)] :
            nx, ny = x + d[0], y + d[1]
            if isInArea(nx, ny) and visited[nx][ny] == 0 :
                if block == 2 :
                    _dfs(x, y, nx, ny, board[nx][ny] + total, block + 1)
                _dfs(nx, ny, nx, ny, board[nx][ny] + total, block + 1)
            
if __name__ == "__main__" :
    N, M = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    visited = [[0] * M for _ in range(N)]
    result = 0
    max_block_val = max(map(max, board))
    for i in range(N) :
        for j in range(M) :
            _dfs(i, j, i, j, board[i][j], 1)
    print(result)
