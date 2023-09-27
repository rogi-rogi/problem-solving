A, B = map(int, input().split())
print([2*B + 1, 2*A - 1][B >= A - 1])
