def solve():
    if N == 1:
        return 1
    if N == 2:
        return 3

    dp = [0] * (N + 1)
    dp[1] = 1
    dp[2] = 3
    for i in range(3, N + 1):
        dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD

    return dp[N]


if __name__ == '__main__':
    # Input
    N = int(input())
    MOD = 20_100_529

    # Solve & Output
    print(solve())
