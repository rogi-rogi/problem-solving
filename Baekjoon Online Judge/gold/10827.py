from decimal import *
getcontext().prec = 1100
a, b = map(Decimal, input().split())
print('{0:f}'.format(Decimal(a**b)))
