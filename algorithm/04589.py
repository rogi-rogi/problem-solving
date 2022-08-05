res = "Gnomes:\n"
for _ in range(int(input())) :
    t = [*map(int, input().split())]
    if t[0] <= t[1] <= t[2] or t[0] >= t[1] >= t[2] : res += "Ordered\n"
    else : res += "Unordered\n"
print(res)
