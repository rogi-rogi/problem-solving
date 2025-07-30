'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-sum-path-in-square/description
'''

N = int(input())
grid = [None] + [[0, *map(int, input().split())] for _ in range(N)]

# Please write your code here.

INF = int(1e10)
dp = [[INF] * (N + 2) for _ in range(N + 1)]

dp[1][N] = grid[1][N]
for j in range(N - 1, 0, -1):
    dp[1][j] = grid[1][j] + dp[1][j + 1]

for i in range(2, N + 1):
    for j in range(N, 0, -1):
        dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j + 1])

print(dp[N][1])