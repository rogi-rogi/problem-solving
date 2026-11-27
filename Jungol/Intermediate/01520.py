from sys import stdin

input = stdin.readline


def solve():
    dp = [0] * (N + 1)
    dp[1] = A[1]

    if N >= 2:
        dp[2] = A[2] + dp[1]

    for i in range(3, N + 1):
        dp[i] = A[i] + max(dp[i - 2], dp[i - 3] + A[i - 1])

    return dp[N]


if __name__ == '__main__':
    # Input
    N = int(input())
    A = [0] + [int(input()) for _ in range(N)]

    # Solve & Output
    print(solve())

