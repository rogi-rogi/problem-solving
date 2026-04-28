for _ in range(int(input())) :
    a, b = map(float, input().split())
    print(round(abs(b - a), 1))