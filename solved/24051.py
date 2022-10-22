#pypy3
def insertionSort() :
    if (N * (N - 1)) // 2 < K : return print(-1)
    swap_cnt = 0
    for i in range(1, N) :
        temp = A[i]
        if A[i - 1] > temp :
            while A[i - 1] > temp and i >= 1 :
                A[i] = A[i - 1]
                swap_cnt += 1
                if swap_cnt == K : return print(A[i - 1])
                i -= 1
            A[i] = temp
            swap_cnt += 1
            if swap_cnt == K : return print(A[i])
    print(-1)

N, K = map(int, input().split())
A = [*map(int, input().split())]
insertionSort()
