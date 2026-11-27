'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-difference-on-the-integer-grid-2/description
'''

N = int(input())
grid = [None] + [[0, *map(int, input().split())] for _ in range(N)]

# Please write your code here.

INF = int(1e10)
dp = [[[INF] * 101 for _ in range(N + 1)] for _ in range(N + 1)]

dp[1][1][grid[1][1]] = grid[1][1]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        for k in range(1, 101):
            min_k = min(k, grid[i][j])
            dp[i][j][min_k] = min(dp[i][j][min_k],
                                max(grid[i][j], min(dp[i - 1][j][k], dp[i][j - 1][k])))

res = INF
for k in range(1, 101):
    if dp[N][N][k] != INF:
        res = min(res, dp[N][N][k] - k)
print(res)