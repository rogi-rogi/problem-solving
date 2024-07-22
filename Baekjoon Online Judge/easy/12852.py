from sys import stdin
input = stdin.readline

SIZE = int(1e6) + 1

if __name__ == '__main__':
    # Input
    N = int(input())

    # Solve
    dp = [0] * SIZE
    path = [0] * SIZE
    path[0] = path[1] = -1

    for i in range(2, N + 1):
        path[i] = i - 1
        dp[i] = dp[path[i]] + 1

        if i % 2 == 0 and dp[i] > dp[i // 2] + 1:
            path[i] = i // 2
            dp[i] = dp[path[i]] + 1
        if i % 3 == 0 and dp[i] > dp[i // 3] + 1:
            path[i] = i // 3
            dp[i] = dp[path[i]] + 1

    # Output
    print(dp[N])
    res = []
    while N != -1:
        res.append(N)
        N = path[N]
    print(*res)
