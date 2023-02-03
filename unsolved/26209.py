N = [*map(int, input().split())]
res = 'S'
for n in N :
    if n > 1 : 
        res = 'F'
        break
print(res)
