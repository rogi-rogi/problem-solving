def combination(n, k, mod_prime) :
    sub_fac = 1
    for i in range(n, n - k, -1) : sub_fac = sub_fac * i % mod_prime
    fac = 1
    for i in range(k, 1, -1) : fac = fac * i % mod_prime
    return sub_fac * pow(fac, mod_prime - 2, mod_prime) % mod_prime

def LucasCombination(m, n, mod_prime) :
    result = 1
    while m or n :
        result = result * combination(m % mod_prime, n % mod_prime, mod_prime) % mod_prime
        m //= mod_prime
        n //= mod_prime
    return result
    
if __name__ == "__main__" :
    N, K, M = map(int, input().split())
    print(LucasCombination(N, K, M))
