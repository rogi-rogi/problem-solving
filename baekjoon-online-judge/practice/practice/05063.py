for _ in range(int(input())):
    r, e, c = map(int, input().split())
    res = 'advertise'
    if r > e - c:
        res = 'do not advertise'
    elif r == e - c:
        res = 'does not matter'
    print(res)
