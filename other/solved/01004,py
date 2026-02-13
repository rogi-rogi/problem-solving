from sys import stdin
input = stdin.readline

for _ in range(int(input())) :
    x1, y1, x2, y2 = map(int, input().split())
    cnt = 0
    for _ in range(int(input())) :
        x, y, r = map(int, input().split())
        R = r**2
        d1 = (x - x1)**2 + (y - y1)**2
        d2 = (x - x2)**2 + (y - y2)**2
        if d1 < R and d2 < R : continue
        if d1 < R or d2 < R: cnt += 1
    print(cnt)
