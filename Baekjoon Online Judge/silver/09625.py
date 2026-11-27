dp = [[0] * 46 for _ in range(46)]
dp[1][0] = dp[2][1] = 0
dp[1][1] = dp[2][0] = 1
for i in range(2, 46) :
    dp[i][0] = dp[i - 1][1]
    dp[i][1] = dp[i - 1][0] + dp[i - 1][1]
K = int(input())
print(dp[K][0], dp[K][1])
