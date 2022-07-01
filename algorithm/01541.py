f = [sum(map(int, x.split('+'))) for x in input().split('-')]
print(f[0] - f[1:])
