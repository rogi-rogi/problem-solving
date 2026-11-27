from math import gcd
N = int(input())
r = list(map(int, input().split()))
for i in range(1, N) :
    g = gcd(r[0], r[i])
    print(r[0]//g, '/', r[i]//g, sep = '')
