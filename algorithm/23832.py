def EulerList(n):
    euler_list = list(range(n+1))
    for p in range(2, n + 1):
        if euler_list[p] == p : 
            for q in range(p, n+1, p):
                euler_list[q] = euler_list[q] // p * (p - 1)
    return euler_list

if __name__ == "__main__" :
    print(sum(EulerList(int(input()))) - 1)

    
#pypy3
#Euler phi function ver
def EPF(N) :
    euler = N
    p = 2
    # for p in range(2, int(N ** (1/2) + 1)) :
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
