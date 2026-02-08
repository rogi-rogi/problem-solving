a, b, c = sorted([*map(int, input().split())])
if a + b > c or a == b == c : print(sum([a, b, c]))
else : print(2 * (a + b) - 1)
