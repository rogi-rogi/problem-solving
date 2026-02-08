while True :
    op = "-\(@?>&%/"
    O = input()
    if O == "#" : break
    res, exponent = 0, 0
    for i in O[::-1] :
        res += (-1 if i == '/' else op.index(i)) * pow(8, exponent)
        exponent += 1
    print(res)
