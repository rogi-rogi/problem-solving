while True :
    x, y = map(float, input().split())
    if x == 0 or y == 0 :
        print("AXIS")
        if x == y : break
    elif y > 0 : print(["Q1", "Q2"][x < 0])
    else : print(["Q4", "Q3"][x < 0]) 
