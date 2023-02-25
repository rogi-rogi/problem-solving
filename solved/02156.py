from sys import stdin
input = stdin.readline

N = int(input())
nums = [int(input()) for _ in range(N)]
dp = [0] * N

dp[0] = nums[0]
if N >= 2 :
    dp[1] = nums[0] + nums[1] 
    if N >= 3 :
        dp[2] = max(dp[1], dp[0] + nums[2], nums[1] + nums[2])

'''
D : drink
N : not drink

N D D N : dp[i - 1]
D D N D : dp[i - 2] + nums[i]
D N D D : dp[i - 3] + nums[i - 1] + nums[i]
'''
for i in range(3, N) :
    dp[i] = max(dp[i - 1], dp[i - 2] + nums[i], dp[i - 3] + nums[i - 1] + nums[i])
print(dp[N - 1])
