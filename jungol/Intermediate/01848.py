if __name__ == '__main__':
    # Input
    N = int(input())
    M = int(input())
    vip = [int(input()) for _ in range(M)]

    # Solve
    dp = [0] * (N + 1)
    dp[0] = 1
    dp[1] = 1

    for i in range(2, N + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    answer = 1
    prev = 0

    for cur in vip:
        length = cur - prev - 1
        answer *= dp[length]
        prev = cur

    length = N - prev
    answer *= dp[length]

    # Output
    print(answer)