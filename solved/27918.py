X, Y = 0, 0
for _ in range(int(input())) :
    user = input()
    if user == 'D' : X += 1
    else : Y += 1
    if abs(X - Y) == 2 : break    
print("%d:%d" %(X, Y))
