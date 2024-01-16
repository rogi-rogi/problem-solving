for _ in range(int(input())) :
    X, Y = map(int, input().split())
    print(["MMM BRAINS", "NO BRAINS"][X < Y])
