while True :
    N = input()
    if N == '0' : break
    res = len(N) + 1
    for num in N :
        if num == '0' : res += 4
        elif num == '1' : res += 2
        else : res += 3
    print(res)
