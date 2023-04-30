from sys import stdin
input = stdin.readline

U, D = 0, 1

for _ in range(int(input())) :
    n = int(input())
    dp = [[*map(int, input().split())] for _ in range(2)]
    if n == 1 : print(max(dp[U][0], dp[D][0]))
    else :
        dp[U][1] += dp[D][0]
        dp[D][1] += dp[U][0] 
        for i in range(2, n) :
            dp[U][i] += max(dp[D][i - 1], dp[D][i - 2])
            dp[D][i] += max(dp[U][i - 1], dp[U][i - 2])
        print(max(dp[U][n - 1], dp[D][n - 1]))
