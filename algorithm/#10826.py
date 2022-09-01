dp = [0, 1]
n = int(input())
for i in range(2, n + 1) :
    if i % 2 == 0 : dp[0] += dp[1]
    else : dp[1] += dp[0]
print(dp[n % 2])
