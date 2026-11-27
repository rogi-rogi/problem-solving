def LDS() : # Longest Decreasing Subsequence
    for i in range(N - 1, -1, -1) : 
        for j in range(N - 1, i, -1) :
            if A[j] < A[i] and dp[j] == dp[i] :
                dp[i] = dp[j] + 1
    '''
    for i in range(N) :
        for j in range(i) :
            if A[j] > A[i] and dp[j] == dp[i] :
                dp[i] = dp[j] + 1
    '''

if __name__ == "__main__" :
    N = int(input())
    A = [*map(int, input().split())]
    dp = [1] * N
    LDS()
    print(max(dp))
