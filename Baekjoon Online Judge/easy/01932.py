from collections import defaultdict
from sys import stdin
input = stdin.readline

SIZE = 501

if __name__ == '__main__':
    # Input
    N = int(input())
    arr = defaultdict(list)
    for i in range(1, N + 1):
        arr[i] = [0, *map(int, input().split()), 0]

    # Solve
    dp = [[0] * (i + 2) for i in range(N + 1)]
    dp[1][1] = arr[1][1]
    for i in range(2, N + 1):
        for j in range(1, i + 1):
            dp[i][j] = arr[i][j] + max(dp[i - 1][j - 1], dp[i - 1][j])

    # Output
    print(max(dp[N]))
