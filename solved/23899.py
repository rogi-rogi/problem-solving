N = int(input())
A = [*map(int, input().split())]
B = [*map(int, input().split())]
change = 0
if A == B : print(1)
else :
    for i in range(N, 1, -1) :
        max_idx = A.index(max(A[:i]))
        if max_idx != i - 1 :
            change += 1
            A[max_idx], A[i - 1] = A[i - 1], A[max_idx]
            if A == B :
                print(1)
                exit(0)
    print(0)
