N, K = map(int, input().split())
res, cnt = 0, 0
for num in range(1, N + 1) :
    if N % num == 0 :
        cnt += 1
        if cnt == K :
            res = num
            break
print(res)