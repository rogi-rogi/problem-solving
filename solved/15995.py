a, m = map(int, input().split())
for x in range(1, m) : 
    if a * x % m == 1 :
        print(x)
        break
