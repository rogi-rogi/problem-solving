D, H, M = map(int, input().split())
res = ((D - 11) * 60 * 24) + ((H - 11) * 60) + (M - 11)
print([res, -1][res < 0])
