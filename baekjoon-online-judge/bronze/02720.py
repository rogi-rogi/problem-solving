for _ in range(int(input())) :
    C = int(input())
    res = []
    for money in [25, 10, 5, 1] :
        res.append(C // money)
        C %= money
    print(*res)
