'''
https://www.codetree.ai/missions/2/problems/number-of-unique-bst?&utm_source=clipboard&utm_medium=text
'''

# Init
SIZE = 20

# Input
N = int(input())

# Solve
dp = [0] * SIZE
dp[0] = 1
dp[1] = 1
dp[2] = 2
dp[3] = 5
for i in range(4, N + 1):
    for j in range(0, i):
        dp[i] += dp[j] * dp[i - 1 - j]

# Output
print(dp[N])
