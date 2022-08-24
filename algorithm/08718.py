x, k = map(int, input().split())
x *= 1000
k *= 1000
if x >= 7 * k : res = 7 * k
elif x >= 3 * k + k // 2 : res = 3 * k + k // 2
else : res = k + k // 2 + k // 4
print([res, 0][res > x])
