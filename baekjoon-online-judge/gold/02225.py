if __name__ == "__main__" :
    N, K = map(int, input().split())
    if K == 1 : print(1)
    else :
        dp = [1] * (N + 1)
        for _ in range(1, K) :
            for j in range(1, N + 1) :
                dp[j] = (dp[j - 1] + dp[j]) % int(1e9)
        print(dp[N])
