a, b = map(int, input().split())
print([1, 0][a - (a * b / 100) >= 100])
