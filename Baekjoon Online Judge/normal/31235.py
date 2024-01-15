if __name__ == "__main__" :
    N = int(input())
    A = [*map(int, input().split())]
    prevMaxA = A[0]
    cnt = 1
    K = 1
    for i in range(1, N) :
        if A[i] < prevMaxA :
            cnt += 1
            K = max(K, cnt)
        else :
            prevMaxA = A[i]
            cnt = 1
    print(K)
