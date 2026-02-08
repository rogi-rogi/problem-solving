for _ in range(int(input())) :
    y, m, d = map(int, input().split())
    res = 'No'
    if y < 1989:
        res = 'Yes'
    elif y == 1989 and (m < 2 or (m == 2 and d < 28)):
        res = 'Yes'
    print(res)
