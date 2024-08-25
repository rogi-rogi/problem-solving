'''
https://www.codetree.ai/missions/2/problems/lis-on-the-integer-grid?&utm_source=clipboard&utm_medium=text
'''

from sys import setrecursionlimit

# Init
setrecursionlimit(3 * int(1e5))
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
SIZE = 501

def in_area(x, y):
    return 1 <= x <= N and 1 <= y <= N

def dfs(x, y):
    if dp[x][y] > 0:
        return dp[x][y]

    res = 1
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if in_area(nx, ny) and matrix[nx][ny] > matrix[x][y]:
            res = max(res, dfs(nx, ny) + 1)
    dp[x][y] = res       
    return dp[x][y]

if __name__ == '__main__':
    # Input
    N = int(input())
    matrix = [None] + [[0, *map(int, input().split())] for _ in range(N)]
    
    # Solve
    dp = [[0] * SIZE for _ in range(SIZE)]
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if dp[i][j] == 0:
                dfs(i, j)

    # Output
    print(max(max(dp[i]) for i in range(1, N + 1)))
