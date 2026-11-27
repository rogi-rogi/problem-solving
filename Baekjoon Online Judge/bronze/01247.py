for _ in range(3) :
    num = sum([int(input()) for _ in range(int(input()))])
    res = 0
    if   num > 0 : res = '+'
    elif num < 0 : res = '-'
    print(res)
