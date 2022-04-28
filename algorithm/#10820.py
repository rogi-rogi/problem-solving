while True :
    try :
        lower = 0
        upper = 0
        num = 0
        space = 0
        for i in list(input()) :
            if 97 <= ord(i) <= 122 : lower += 1
            elif 65 <= ord(i) <= 90 : upper += 1
            elif ord(i) == 32 : space += 1
            else : num += 1
        print(lower, upper, num, space)
    except : break
