def EulerPhi(n) :
    euler = n
    prime = 2
    while prime * prime <= n :
        if n % prime == 0:
            euler -= euler // prime
            while n % prime == 0 : n //= prime
        prime += 1
    return euler if n == 1 else euler - euler // n

def exponial(N, M) :
    if N == 1 or M == 1 : return 1
    if N <= 5 :
        return pow(N, exponial(N - 1, M), M)
    EP = EulerPhi(M)
    return pow(N, exponial(N - 1, EP) + EP, M)

if __name__ == "__main__" :
    N, M = map(int, input().split())
    print(exponial(N, M) % M)
