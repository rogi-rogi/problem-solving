#pypy3
def EPF(N) :
    euler = N
    p = 2
    while p * p <= N :
        if N % p == 0 : euler = euler // p * (p - 1)
        while N % p == 0 : N = N // p
        p += 1
    return euler if N == 1 else euler // N * (N - 1)

if __name__ == "__main__" :
    total = 0
    for i in range(2, int(input()) + 1) :
        total += EPF(i)
    print(total)
