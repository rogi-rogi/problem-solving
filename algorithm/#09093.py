for _ in range(int(input())) :
    res = ""
    for i in list(input().split()) :
        res += i[::-1] + ' '
    print(res)
