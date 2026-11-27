while True :
    try :
        lower = 0
        upper = 0
        num = 0
        space = 0
        for i in list(input()) :
            if i.islower() : lower += 1
            elif i.isupper() : upper += 1
            elif i.isdigit() : num += 1
            else : space += 1
        print(lower, upper, num, space)
    except : break
