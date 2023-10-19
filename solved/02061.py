P, K = map(int, input().split())
res = "GOOD"
for num in range(2, K) :
    if P % num == 0 : 
        res = f"BAD {num}"
        break
print(res)
