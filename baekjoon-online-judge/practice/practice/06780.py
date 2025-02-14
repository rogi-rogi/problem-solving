t1 = int(input())
t2 = int(input())
res = [t1, t2]
cnt = 2
while res[-2] >= res[-1]:
    res.append(res[-2] - res[-1])
    cnt += 1
print(cnt)
