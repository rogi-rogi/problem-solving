from sys import stdin
input = stdin.readline

MOD = int(1e4) + 7

if __name__ == '__main__':
    # Input
    N = int(input())
    dp = [0] * (N + 1)

    # Solve
    dp[1] = 1
    dp[2] = 3
    for i in range(3, N + 1):
        dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD

    # Output
    print(dp[N])
