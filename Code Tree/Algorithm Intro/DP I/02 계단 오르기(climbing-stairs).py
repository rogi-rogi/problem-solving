# Init
SIZE = 1001
MOD = int(1e4) + 7

# Input
N = int(input())

# Solve
dp = [0] * SIZE
dp[2] = 1
dp[3] = 1
for i in range(4, SIZE):
    dp[i] = (dp[i - 2] + dp[i - 3]) % MOD

# Output
print(dp[N])
