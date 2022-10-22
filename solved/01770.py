from math import gcd, factorial
from random import randint
from sys import stdin
input = stdin.readline

def isComposite(a, d, n, s) :
    if a >= n : return False
    if pow(a, d, n) == 1 : return False
    for r in range(s) :
        if pow(a, pow(2, r) * d, n) == n - 1 : return False
    return True

def MillerRabin(n) :
    if n < 2 : return False
    d = n - 1
    s = 0
    while d % 2 == 0 :
        d >>= 1
        s += 1
    for a in (2, 3, 5, 7, 11, 13, 17, 19, 23, 61) :
        if isComposite(a, d, n, s) : return False
    return True

def g(x, c, n) : return (x * x + c) % n

def PollardRho(n) :
    if MillerRabin(n) : return [n]
    if n == 0 : return []
    if n == 1 : return [1]
    if n % 2 == 0 : return PollardRho(n // 2) + [2]
    while True :
        c = randint(1, 9)
        x2 = x1 = randint(1, 9)
        d = 1
        while d == 1 :
            x1 = g(x1, c, n)
            x2 = g(g(x2, c, n), c, n)
            d = gcd(abs(x1 - x2), n)
        if d != n :
            return PollardRho(n // d) + PollardRho(d)

if __name__ == "__main__" :
    for _ in range(int(input())) :
        N = int(input())
        result = 0
        # N == 4 -> 16
        if N == 4 or MillerRabin(N): result = 1
        else :
            factors = sorted(PollardRho(N))
            std = factors[0]
            factors_size = len(factors)
            for i in range(1, factors_size) :
                if factors[i] == std :
                    result = -1
                    break
                else : std = factors[i]
            if result == 0 :
                result = factorial(factors_size)
        print(result)
