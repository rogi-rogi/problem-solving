from sys import stdin
input = stdin.readline

for _ in range(int(input())) :
    clothes_types = []
    for _ in range(int(input())) :
        clothes_types.append(input().split()[1])
    set_clothes = set(clothes_types)
    cnt = 1
    for i in set_clothes :
        cnt *= (clothes_types.count(i) + 1)
    print(cnt - 1)
