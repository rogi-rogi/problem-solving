'''
https://www.codetree.ai/missions/2/problems/fibonacci-number?&utm_source=clipboard&utm_medium=text
'''

# Init
SIZE = 1001

# Input
N = int(input())

# Solve
dp = [1] * SIZE
dp[1] = 1
dp[2] = 1
for i in range(3, SIZE):
    dp[i] = dp[i - 1] + dp[i - 2]

# Output
print(dp[N])
