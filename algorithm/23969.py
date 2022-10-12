#pypy3
def bubbleSort() :
    swap_cnt = 0
    for i in range(N, 0, -1) :
        for j in range(i - 1) :
            if arr[j] > arr[j + 1] :
                swap_cnt += 1
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                if swap_cnt == K : return swap_cnt
    return swap_cnt
    
N, K = map(int, input().split())
arr = [*map(int, input().split())]
if bubbleSort() == K : print(*arr)
else : print(-1)
