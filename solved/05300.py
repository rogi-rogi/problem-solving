res = []
for i in range(1, int(input()) + 1) :
    res.append(i)
    if i % 6 == 0 : res.append('Go!')
if res[-1] != 'Go!' : res.append('Go!')
print(*res)
