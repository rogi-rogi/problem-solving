dp = [-1] * 100001
dp[1] = dp[3] = -1
dp[4] = 2
dp[2] = dp[5] = 1
for i in range(6, 100001) :
    dp[i] = 1 + dp[i - [2, 5][i % 5 == 0]]
print(dp[int(input())])
