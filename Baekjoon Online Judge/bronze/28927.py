time = [3, 20, 120]

Max = sum([x * y for x, y in zip([*map(int, input().split())], time)])
Mel = sum([x * y for x, y in zip([*map(int, input().split())], time)])

res = "Draw"
if Max > Mel : res = "Max"
elif Max < Mel : res = "Mel"
print(res)
