'''
https://www.codetree.ai/missions/2/problems/maximin-path-in-square?&utm_source=clipboard&utm_medium=text
'''

# Init
SIZE = 101

# Input
N = int(input())
matrix = [None] + [[0, *map(int, input().split())] for _ in range(N)]
dp = [[0] * SIZE for _ in range(SIZE)]

# Solve
dp[1][0] = matrix[1][1]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        dp[i][j] = min(matrix[i][j], max(dp[i - 1][j], dp[i][j - 1]))

# Output
print(dp[N][N])
