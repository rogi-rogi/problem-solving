if __name__ == '__main__':
    # Input
    num = [*map(int, [*input().rstrip()])]

    # Solve
    n = len(num)
    dp = [0] * (n + 1)
    dp[0] = 1
    dp[1] = 1

    for i in range(2, n + 1):
        if 1 <= num[i - 1] <= 9:
            dp[i] += dp[i - 1]

        two_digit = num[i - 2] * 10 + num[i - 1]
        if 10 <= two_digit <= 34:
            dp[i] += dp[i - 2]

    # Output
    print(dp[n])