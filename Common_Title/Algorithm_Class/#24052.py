#pypy3
N, K = map(int, input().split())
A = list(map(int, input().split()))
if (N * (N + 1) // 2) - 1 < K : print(-1)
else :
    cnt = 0
    for i in range(1, N) :
        temp = A[i]
        if A[i - 1] > temp :
            while A[i - 1] > temp and i >= 1 :
                A[i] = A[i - 1]
                cnt += 1
                if cnt == K : 
                    for idx in range(N) : print(A[idx], end = " ")
                    exit(0)
                i -= 1
            A[i] = temp
            cnt += 1
            if cnt == K : 
                for idx in range(N) : print(A[idx], end = " ")
                exit(0)
    print(-1)
