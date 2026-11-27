_, cur = map(int, input().split()) 
res = cur
for _ in range(9) :
    d, u = map(int, input().split())
    cur += u - d
    res = max(res, cur)
print(res)
