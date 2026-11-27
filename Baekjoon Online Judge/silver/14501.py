from math import ceil 

x, y = map(int, input().split())
acre = (x * y) / 4840
print(ceil(acre / 5))
