a = int(input())
x = int(input())
b = int(input())
y = int(input())
T = int(input())

print(a + [21*x*(T - 30), 0][T - 30 <= 0], b + [21*y*(T-45), 0][T-45 <= 0])
