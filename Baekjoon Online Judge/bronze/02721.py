for _ in range(int(input())) :
    n = int(input())
    print(sum([k*((k+1)*(k+2))//2 for k in range(1, n + 1)]))
