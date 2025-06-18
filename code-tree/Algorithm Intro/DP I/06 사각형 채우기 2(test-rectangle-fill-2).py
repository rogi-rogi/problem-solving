'''
https://www.codetree.ai/ko/trails/complete/curated-cards/test-rectangle-fill-2/description
'''

# Init
SIZE = 1001
MOD = int(1e4) + 7

# Input
N = int(input())

# Solve
dp = [0] * SIZE
dp[1] = 1
dp[2] = 3
for i in range(3, N + 1):
    dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD

# Output
print(dp[N])
