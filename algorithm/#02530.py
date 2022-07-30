A, B, C = map(int, input().split())
D = int(input())
m = (C + D) // 60
C = (C + D) % 60
h = (B + m) // 60
B = (B + m) % 60
A = (A + h) % 24
print(A, B, C)
