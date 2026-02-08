res = 0
for _ in range(int(input())) :
    a, d, g = map(int, input().split())
    temp = d + g
    res = max(res, a * temp * [1, 2][a == temp])
print(res)
