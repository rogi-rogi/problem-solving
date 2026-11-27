cups = [0, 1, 0, 0]

for _ in range(int(input())) :
    X, Y = map(int, input().split())
    cups[X], cups[Y] = cups[Y],  cups[X]
    
for idx, ball in enumerate(cups) :
    if ball == 1 : print(idx)
