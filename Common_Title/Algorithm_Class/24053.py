#pypy3
N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
if A == B : print(1)
else :
    for i in range(1, N) :
        temp = A[i]
        j = i - 1
        while A[j] > temp and j >= 0 :
            A[j + 1] = A[j]
            if A[j] == B[j] and B[j] == B[j + 1] and A == B :
                print(1)
                exit(0)
            j -= 1
        if j != i - 1 :
            A[j + 1] = temp
            if A == B: 
                print(1)
                exit(0)
    print(0)
