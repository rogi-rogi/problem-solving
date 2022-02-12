#pypy3
N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
change = 0
if A == B : print(1)
else :
    for i in range(N, 0, -1) :
        for j in range(i - 1) :
            if A[j] > A[j + 1] :
                change += 1
                A[j], A[j + 1] = A[j + 1], A[j]
            if A == B :
                print(1)
                exit(0)
    print(0)
