#pypy3
def bubbleSort() :
    swap_cnt = 0
    for i in range(N, 0, -1) :
        for j in range(i - 1) :
            if A[j] > A[j + 1] :
                A[j], A[j + 1] = A[j + 1], A[j]
                swap_cnt += 1
                if swap_cnt == K : 
                    print(A[j], A[j + 1])
                    return 0
    return -1
    
N, K = map(int, input().split())
A = [*map(int, input().split())]
if bubbleSort() == -1 : print(-1)
