from math import lcm

for _ in range(int(input())) :
    M, N, x, y = map(int, input().split())
    for X in range(x, lcm(M, N) + 1, M) :
        if (X - y) % N == 0 :
            print(X)
            break
    else : print(-1)
