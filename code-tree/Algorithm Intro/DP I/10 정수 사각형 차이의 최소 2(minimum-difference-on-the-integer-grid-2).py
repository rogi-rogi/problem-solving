'''
https://www.codetree.ai/missions/2/problems/minimum-difference-on-the-integer-grid-2?&utm_source=clipboard&utm_medium=text
'''

# Init
SIZE = 101
INF = int(1e10)

# Input
N = int(input())
matrix = [None] + [[0, *map(int, input().split())] for _ in range(N)]
dp = [[[INF] * SIZE for _ in range(SIZE)] for _ in range(SIZE)]

# Solve
dp[1][1][matrix[1][1]] = matrix[1][1]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        for k in range(1, SIZE):
            min_k = min(k, matrix[i][j])
            dp[i][j][min_k] = min(dp[i][j][min_k], max(matrix[i][j], min(dp[i - 1][j][k], dp[i][j - 1][k])))

# Output
res = INF
for k in range(1, SIZE):
    if dp[N][N][k] != INF and dp[N][N][k] - k < res:
        res = dp[N][N][k] - k
print(res)
