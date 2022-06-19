def EulerPhi(n) :
    euler = n
    prime = 2
    while prime * prime <= n :
        if n % prime == 0:
            euler -= euler // prime
            while n % prime == 0 : n //= prime
        prime += 1
    return euler if n == 1 else euler - euler // n

def f(N, M) :
    if N == 1 or M == 1 : return 1
    EP = EulerPhi(M)
    return pow(N, f(N, EP) + EP, M)

if __name__ == "__main__" :
    for _ in range(int(input())) :
        N, M = map(int, input().split())
        print(f(N, M) % M)
