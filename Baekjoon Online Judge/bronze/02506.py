_ = input()
res, cnt = 0, 1;
for num in [*map(int, input().split())] :
    if num == 0 : cnt = 1
    else :
        res += cnt
        cnt += 1
print(res)
