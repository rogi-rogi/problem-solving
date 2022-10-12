#pypy3
def bubbleSort() :
    swap_cnt = 0
    for i in range(N, 0, -1) :
        for j in range(i - 1) :
            if A[j] > A[j + 1] :
                swap_cnt += 1
                A[j], A[j + 1] = A[j + 1], A[j]
                if swap_cnt == K : return swap_cnt
    return swap_cnt
    
N, K = map(int, input().split())
A = [*map(int, input().split())]
if bubbleSort() == K : print(*A)
else : print(-1)
