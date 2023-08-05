g, p, t = map(int, input().split())
res = 0
if g*p < g + t*p : res = 1
elif g*p > g + t*p : res = 2
print(res)
