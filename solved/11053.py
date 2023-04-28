def LIS() : # Longest Increasing Subsequence
    for i in range(N) :
        for j in range(i) :
            if A[j] < A[i] and dp[j] == dp[i] :
                dp[i] = dp[j] + 1

if __name__ == "__main__" :
    N = int(input())
    A = [*map(int, input().split())]
    dp = [1] * N
    LIS()
    print(max(dp))
