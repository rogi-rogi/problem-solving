#pypy3
def insertionSort() :
    if A == B : return 1
    for i in range(1, N) :
        temp = A[i]
        if A[i - 1] > temp :
            while A[i - 1] > temp and i >= 1 :
                A[i] = A[i - 1]
                if A[i - 1] == B[i - 1] == B[i] and A == B : return 1
                i -= 1
            A[i] = temp
            if A[i] == B[i] and A == B : return 1
    return 0

N = int(input())
A = [*map(int, input().split())]
B = [*map(int, input().split())]
print(insertionSort())
