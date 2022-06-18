from decimal import *
getcontext().prec = 10000
a, b = map(Decimal, input().split())
print('{0:f}'.format(Decimal(a**b)))
