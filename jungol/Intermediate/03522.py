def fibo():
    dp = [0] * (N + 1)
    dp[1] = 1
    dp[2] = 1

    for i in range(3, N + 1):
        dp[i] = (dp[i - 1] + dp[i - 2]) % MOD
    return dp[N]


if __name__ == '__main__':
    # Input
    N = int(input())
    MOD = int(1e9) + 7

    # Solve & Output
    print(fibo())
