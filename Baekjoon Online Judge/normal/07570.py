from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    nums = [*map(int, input().split())]
    dp = [0] * (N + 1)
    LIS_length = 0
    for num in nums :
        dp[num] = dp[num - 1] + 1
        LIS_length = max(LIS_length, dp[num - 1] + 1)
    print(N - LIS_length)
