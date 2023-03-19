p = int(input())
q = int(input())

res = "Yellow"
if p <= 50 and q <= 10 : res = "White"
elif q > 30 : res = "Red"
print(res)
