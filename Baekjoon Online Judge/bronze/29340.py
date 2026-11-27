a = [*map(int, input())]
b = [*map(int, input())]
res = []
for i in range(len(a)) :
    res.append(max(a[i], b[i]))
print(*res, sep='')
