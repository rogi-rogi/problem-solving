#pypy3

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
if A == B : print(1)
else :
    for i in range(N - 1, 0, -1) :
        for j in range(i) :
            if A[j] > A[j + 1] :
                A[j], A[j + 1] = A[j + 1], A[j]
                if A[j] == B[j] and A[j+1] == B[j+1] and A == B:
                    print(1)
                    exit(0)
        if A[i] != B[i] : break
    print(0)
