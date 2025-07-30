'''
https://www.codetree.ai/missions/2/problems/max-of-partial-sum?&utm_source=clipboard&utm_medium=text
'''

# Init
SIZE = int(1e5+1)
MIN = int(-1e10)

# Input
N = int(input())
arr = [0, *map(int, input().split())]

# Solve
dp = [MIN] * SIZE
for i in range(1, N + 1):
    dp[i] = max(dp[i - 1] + arr[i], arr[i])

# Output
print(max(dp))
