from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    T = [0] * N
    P = [0] * N
    for i in range(N):
        T[i], P[i] = map(int, input().split())

    # Solve
    dp = [0] * (N + 1)
    for i in range(N - 1, -1, -1):
        t = T[i]
        if i + t <= N:
            dp[i] = max(dp[i + 1], dp[i + t] + P[i])
        else:
            dp[i] = dp[i + 1]

    # Output
    print(dp[0])
