'''
https://www.codetree.ai/missions/2/problems/minimum-sum-path-in-square?&utm_source=clipboard&utm_medium=text
'''

# Init
SIZE = 101
INF = int(1e10)

# Input
N = int(input())
matrix = [None] + [[0, *map(int, input().split())] for _ in range(N)]
dp = [[INF] * (SIZE + 1) for _ in range(SIZE)]

# Solve
dp[1][N] = matrix[1][N]
for j in range(N - 1, 0, -1):
    dp[1][j] = matrix[1][j] + dp[1][j + 1]
    
for i in range(2, N + 1):
    for j in range(N, 0, -1):
        dp[i][j] = matrix[i][j] + min(dp[i - 1][j], dp[i][j + 1])

# Output
print(dp[N][1])
