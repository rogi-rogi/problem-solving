from sys import stdin
input = stdin.readline


if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())
    A = [0, *map(int, input().split())]

    # Solve
    dp = [0] * (N + 1)
    for _ in range(M):
        i, w = map(int, input().split())
        dp[i] += w

    for i in range(2, N + 1):
        dp[i] += dp[A[i]]

    # Output
    del dp[0]
    print(*dp)