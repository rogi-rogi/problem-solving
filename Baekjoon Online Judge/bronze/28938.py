input()
p = sum([*map(int, input().split())])
res = "Stay"
if p > 0 : res = "Right"
if p < 0 : res = "Left"
print(res)
