N, K = map(int, input().split())
dp = [[0] * k for k in range(1, N + 2)]
dp[1] = [1, 1]
for n in range(2, N+1) :
    dp[n][0] = 1
    for k in range(1, n) :
        dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k]) % 10007
    dp[n][-1] = 1
print(dp[N][K])
