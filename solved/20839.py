X, Y, Z = map(int, input().split())
x, y, z = map(int, input().split())

score = 'E'
if z == Z : 
    if y == Y:
        if x == X : score = 'A'
        elif x >= X / 2 : score = 'B'
        else : score = 'C'
    elif y >= Y / 2 : score = 'D'
print(score)
