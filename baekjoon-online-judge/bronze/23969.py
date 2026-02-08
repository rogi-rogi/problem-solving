#pypy3
def bubbleSort() :
    swap_cnt = 0
    for i in range(N, 0, -1) :
        for j in range(i - 1) :
            if A[j] > A[j + 1] :
                swap_cnt += 1
                A[j], A[j + 1] = A[j + 1], A[j]
                if swap_cnt == K : return print(*A)
    print(-1)
    
N, K = map(int, input().split())
A = [*map(int, input().split())]
bubbleSort()
