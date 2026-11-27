from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    T, W = map(int, input().split())
    jadu = [0] + [int(input()) for _ in range(T)]

    # Solve
    dp = [[0] * (W + 1) for _ in range(T + 1)]
    for t in range(1, T + 1):
        dp[t][0] = dp[t - 1][0] + (1 if jadu[t] == 1 else 0)
        for w in range(1, W + 1):
            dp[t][w] = max(dp[t - 1][w - 1], dp[t - 1][w]) + (jadu[t] % 2 if w % 2 == 0 else jadu[t] // 2)

    # Output
    print(max(dp[T]))
