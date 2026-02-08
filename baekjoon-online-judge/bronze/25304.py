X = int(input())
res = 0
for _ in range(int(input())) :
    a, b = map(int, input().split())
    res += a * b
print(["No", "Yes"][res == X])
