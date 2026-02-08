W, H, X, Y, P = map(int, input().split())
cnt = 0
c1 = [X, Y + H // 2]
c2 = [X + W, Y + H // 2]
for _ in range(P) :
    x, y = map(int, input().split())
    if Y <= y <= Y + H and X <= x <= X + W : cnt += 1
    elif (((x - c1[0]) ** 2 + (y - c1[1]) ** 2) ** (0.5) <= H // 2) or (((x - c2[0]) ** 2 + (y - c2[1]) ** 2) ** (0.5) <= H // 2) : cnt += 1
print(cnt)
