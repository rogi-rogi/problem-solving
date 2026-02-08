for _ in range(int(input())) :
    string = input()
    res = string[0]
    for char in string[1:] :
        if char != res[-1] :
            res += char
    print(*res, sep = '')
