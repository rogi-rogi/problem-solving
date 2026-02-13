from math import floor

N, M = map(float, input().split())
print('%.2f' % (floor((7.0*N/(N+M))*100) / 100))
