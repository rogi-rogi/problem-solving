res = 10000
for _ in range(int(input())) :
    num1, num2 = map(int, input().split())
    res = min(res, num2 // num1)
print(res)
