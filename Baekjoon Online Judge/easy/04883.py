from math import inf
from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    t = 1
    while True:
        N = int(input())
        if N == 0: break
        graph = [None] + [[inf] + [*map(int, input().split())] for _ in range(N)]

        # Solve
        dp = [[inf] * 4 for _ in range(N + 1)]
        dp[1][1] = inf
        dp[1][2] = graph[1][2]
        dp[1][3] = dp[1][2] + graph[1][3]
        for f in range(2, N + 1):
            dp[f][1] = min(dp[f - 1][1], dp[f - 1][2]) + graph[f][1]
            dp[f][2] = min(*dp[f - 1], dp[f][1]) + graph[f][2]
            dp[f][3] = min(dp[f - 1][2], dp[f - 1][3], dp[f][2]) + graph[f][3]

        # Output
        print(f'{t}. {dp[N][2]}')
        t += 1
