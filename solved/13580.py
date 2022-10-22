TM = sorted([*map(int, input().split())])
res = TM[0] == TM[1] or TM[1] == TM[2] or TM[2] == TM[1] + TM[0]
print(['N', 'S'][res])
