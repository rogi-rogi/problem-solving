N, K = map(int, input().split())
arr = list(map(int, input().split()))
change = 0
for i in range(N, 1, -1) :
    max_idx = arr.index(max(arr[:i]))
    
    if max_idx != i - 1 :
        change += 1
        arr[max_idx], arr[i - 1] = arr[i - 1], arr[max_idx]
        if change == K :
            for val in arr : print(val, end = ' ')
            exit(0)
if change < K : print(-1)
