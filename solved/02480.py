a, b, c = map(int, input().split())
if a == b== c : print(10000 + a * 1000)
elif a == b or b == c : print(1000 + b * 100)
elif a == c : print(1000 + a * 100)
else: print(max(a, b, c) * 100)

#short ver
a, b, c = sorted(map(int, input().split()))
print([c, b + 10, b * 10 + 100][[a, b, c].count(b) - 1] * 100)
