for _ in range(int(input())) :
    S = input()
    print([S, S + '.'][S[-1] != '.'])
