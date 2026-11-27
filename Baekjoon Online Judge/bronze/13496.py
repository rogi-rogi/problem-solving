for i in range(int(input())) :
    N, S, D = map(int, input().split())
    cnt = 0
    for _ in range(N) :
        d, v = map(int, input().split())
        if S * D >= d : cnt += v
    print(f"Data Set {i + 1}: \n{cnt}\n")
