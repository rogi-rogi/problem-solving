N, K = map(int, input().split())
G = [*map(int, input().split())]
for i in range(K) :
    G[i] = (G[i] * 100) // N
res = []
for g in G :
    if   g <= 4 : res.append(1)
    elif g <= 11 : res.append(2)
    elif g <= 23 : res.append(3)
    elif g <= 40 : res.append(4)
    elif g <= 60 : res.append(5)
    elif g <= 77 : res.append(6)
    elif g <= 89 : res.append(7)
    elif g <= 96 : res.append(8)
    elif g <= 100 : res.append(9)
print(*res)
