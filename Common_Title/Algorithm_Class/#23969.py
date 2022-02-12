#pypy3
N, K = map(int, input().split())
arr = list(map(int, input().split()))
change = 0
for i in range(N, 0, -1) :
    for j in range(i - 1) :
        if arr[j] > arr[j + 1] :
            change += 1
            arr[j], arr[j + 1] = arr[j + 1], arr[j]
        if change == K :
            for val in arr : print(val, end = ' ')
            exit(0)
if change < K : print(-1)
