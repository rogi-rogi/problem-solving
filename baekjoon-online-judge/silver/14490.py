from math import gcd

N, M = map(int, input().split(':'))
div = gcd(N, M)
print(f"{N//div}:{M//div}")
