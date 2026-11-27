def selectionSort() :
    swap_cnt = 0
    for i in range(N - 1, 0, -1) :
        max_idx = A.index(max(A[:i + 1]))
        if max_idx != i :
            A[max_idx], A[i] = A[i], A[max_idx]
            swap_cnt += 1
            if swap_cnt == K : return print(*A)
    print(-1)
    
N, K = map(int, input().split())
A = [*map(int, input().split())]
selectionSort()
