'''
https://www.codetree.ai/missions/2/problems/rectangle-fill-3?&utm_source=clipboard&utm_medium=text
'''

# Init
SIZE = 1001
MOD = int(1e9) + 7

# Input
N = int(input())

# Solve
dp = [0] * SIZE
tail_dp = [0] * SIZE
dp[1] = 2
dp[2] = 7
tail_dp[1] = 1
tail_dp[2] = 3
for i in range(3, SIZE):
    dp[i] = (2 * dp[i - 1] + dp[i - 2] + tail_dp[i - 1] * 2) % MOD
    tail_dp[i] = (dp[i - 1] + tail_dp[i - 1]) % MOD
    
# Output
print(dp[N])
