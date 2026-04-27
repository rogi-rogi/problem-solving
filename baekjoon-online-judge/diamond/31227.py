from sys import stdin
input = stdin.readline

N, M = map(int, input().split())

NEG = -10**30

# dp[k][j]
# k = 1: 닫힌 상태
# k = 2: x + y 를 한 번 더한 상태
# k = 3: x + y 를 한 번 뺀 상태
# k = 4: x - y 를 한 번 더한 상태
# k = 5: x - y 를 한 번 뺀 상태
# j = 완성한 구간 수
dp = [[NEG] * (N + 1) for _ in range(6)]
dp[1][0] = 0

for i in range(1, M + 1):
    x, y = map(int, input().split())

    a = x + y
    b = x - y

    ndp = [[NEG] * (N + 1) for _ in range(6)]
    limit = min(N, i)

    for j in range(limit + 1):
        ndp[1][j] = dp[1][j]

        if j > 0:
            ndp[1][j] = max(
                ndp[1][j],
                dp[1][j - 1],
                dp[2][j - 1] - a,
                dp[3][j - 1] + a,
                dp[4][j - 1] - b,
                dp[5][j - 1] + b
            )

        ndp[2][j] = max(dp[2][j], dp[1][j] + a)
        ndp[3][j] = max(dp[3][j], dp[1][j] - a)
        ndp[4][j] = max(dp[4][j], dp[1][j] + b)
        ndp[5][j] = max(dp[5][j], dp[1][j] - b)
    dp = ndp

print(dp[1][N])