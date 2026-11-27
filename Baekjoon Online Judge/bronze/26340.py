for _ in range(int(input())) :
    a, b, n = map(int, input().split())
    print(f"Data set: {a} {b} {n}")
    for _ in range(n):
        if a > b:  a >>= 1
        else :     b >>= 1
    if b > a :
        a, b = b, a
    print(a, b, '\n')
