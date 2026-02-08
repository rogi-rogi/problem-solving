def LBS() : # Longest Bitonic Subsequence
    # LIS
    for i in range(N) :
        for j in range(i) :
            if A[j] < A[i] and dp_LIS[j] == dp_LIS[i] :
                dp_LIS[i] = dp_LIS[j] + 1
    # LDS
    for i in range(N - 1, -1, -1) : 
        for j in range(N - 1, i, -1) :
            if A[j] < A[i] and dp_LDS[j] == dp_LDS[i] :
                dp_LDS[i] = dp_LDS[j] + 1

if __name__ == "__main__" :
    N = int(input())
    A = [*map(int, input().split())]
    dp_LIS = [1] * N
    dp_LDS = [1] * N
    LBS()
    print(max([dp_LIS[i] + dp_LDS[i] for i in range(N)]) - 1)
