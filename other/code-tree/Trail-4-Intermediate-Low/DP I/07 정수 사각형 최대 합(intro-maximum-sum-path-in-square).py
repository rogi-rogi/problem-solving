'''
https://www.codetree.ai/ko/trails/complete/curated-cards/intro-maximum-sum-path-in-square/description
'''

N = int(input())
grid = [list(map(int, input().split())) for _ in range(N)]

# Please write your code here.

dp = [[0] * (N + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, N + 1):
        dp[i][j] = grid[i - 1][j - 1] + max(dp[i - 1][j], dp[i][j - 1])

print(dp[N][N])