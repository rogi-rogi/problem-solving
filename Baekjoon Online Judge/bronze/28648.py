res = 999
for _ in range(int(input())) :
    res = min(res, sum([*map(int, input().split())]))
print(res)
