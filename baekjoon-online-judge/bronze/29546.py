JPG = [input() for _ in range(int(input()))]
for _ in range(int(input())) :
    l, r = map(int, input().split())
    for idx in range(l - 1, r) :
        print(JPG[idx])
