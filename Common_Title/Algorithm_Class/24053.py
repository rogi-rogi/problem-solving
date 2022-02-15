#pypy3
N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
if A == B : print(1)
else :
    for i in range(1, N) :
        temp = A[i]
        if A[i - 1] > temp :
            while A[i - 1] > temp and i >= 1 :
                A[i] = A[i - 1]
                if A[i - 1] == B[i - 1] and B[i - 1] == B[i] and A == B :
                    print(1)
                    exit(0)
                i -= 1
            A[i] = temp
            if A == B: 
                print(1)
                exit(0)
    print(0)
