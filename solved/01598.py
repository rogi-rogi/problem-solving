A, B = map(int, input().split())
x = (B-1)//4 - (A-1)//4
y = (B-1)%4 - (A-1)%4
print(abs(x) + abs(y))
