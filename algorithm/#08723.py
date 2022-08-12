stick = sorted(map(int, input().split()))
res = 0
if stick[0] == stick[1] == stick[2] : res = 2
elif stick[0] ** 2 + stick[1] ** 2 == stick[2] ** 2 : res = 1
print(res)
