'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-increasing-sequence-2d/description
'''

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.

INF = -int(1e10)
dp = [[INF] * m for _ in range(n)]

dp[0][0] = 1
for i in range(n):
    for j in range(m):
        for ni in range(i):
            for nj in range(j):
                if dp[ni][nj] == INF:
                    continue
                if grid[ni][nj] < grid[i][j]:
                    dp[i][j] = max(dp[i][j], dp[ni][nj] + 1)

print(max(max(dp[i]) for i in range(n)))