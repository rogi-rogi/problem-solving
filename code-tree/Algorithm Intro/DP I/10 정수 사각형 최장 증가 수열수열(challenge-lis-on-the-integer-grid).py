'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-lis-on-the-integer-grid/description
'''

from sys import setrecursionlimit
setrecursionlimit(505 * 505)

N = int(input())
grid = [None] + [[0, *map(int, input().split())] for _ in range(N)]

# Please write your code here.
D = [(1, 0), (-1, 0), (0, 1), (0, -1)]

def is_valid(x, y):
    return 1 <= x <= N and 1 <= y <= N

def dfs(x, y):
    if dp[x][y] > 0:
        return dp[x][y]

    res = 1
    for dx, dy in D:
        nx, ny = x + dx, y + dy
        if is_valid(nx, ny) and grid[nx][ny] > grid[x][y]:
            res = max(res, dfs(nx, ny) + 1)
    dp[x][y] = res
    return dp[x][y]


dp = [[0] * (N + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        if dp[i][j] == 0:
            dfs(i, j)

print(max(max(dp[i]) for i in range(1, N + 1)))