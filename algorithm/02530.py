A, B, C = map(int, input().split())
D = int(input())
m = (C + D) // 60
h = (B + m) // 60
print((A + h)%24, (B + m)%60, (C + D)%60)
