N = int(input())
level = [*map(int, input().split())]
res = []
for i in range(N) :
    if level[i] == 300 : res.append(1)
    elif level[i] >=275 : res.append(2)
    elif level[i] >= 250 : res.append(3)
    else : res.append(4)
print(*res)
