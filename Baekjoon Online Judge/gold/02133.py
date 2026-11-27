from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    if N % 2 == 0 :
        size = N // 2
        dp = [0] * (size + 1)
        dp[1] = 3
        for i in range(2, size + 1) :
            dp[i] += dp[i - 1] * 3
            dp[i] += sum([dp[j] * 2 for j in range(i - 2, 0, -1)])
            dp[i] += 2
        print(dp[size])
    else : print(0)
