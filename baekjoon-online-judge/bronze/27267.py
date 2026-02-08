a, b, c, d = map(int, input().split())
A, B = a * b, c * d
if A == B : print('E')
else : print(['P', 'M'][A > B])
