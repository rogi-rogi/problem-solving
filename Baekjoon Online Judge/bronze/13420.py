for _ in range(int(input())) :
    f = input().split(' = ')
    print("correct" if eval(f[0]) == int(f[1]) else "wrong answer")
