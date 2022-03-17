from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    dp = [[1] * 10 for _ in range(64)]
    for i in range(1, 64) :
        for j in range(8, -1, -1) :
            dp[i][j] = dp[i-1][j] + dp[i][j+1]
    for _ in range(int(input())) :
        print(sum(dp[int(input()) - 1]))
