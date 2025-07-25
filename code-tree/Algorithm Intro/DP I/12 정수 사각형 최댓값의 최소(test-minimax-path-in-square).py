'''
https://www.codetree.ai/ko/trails/complete/curated-cards/test-minimax-path-in-square/description
'''

N = int(input())
grid = [None] + [[0, *map(int, input().split())] for _ in range(N)]

# Please write your code here.

INF = int(1e10)
dp = [[INF] * (N + 1) for _ in range(N + 1)]

dp[1][0] = grid[1][1]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        dp[i][j] = max(grid[i][j], min(dp[i - 1][j], dp[i][j - 1]))

print(dp[N][N])