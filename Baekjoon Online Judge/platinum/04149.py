from math import gcd
from random import randint

_primes = (2, 3, 5, 7, 11, 13, 17, 19, 23, 61)

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
    return not any(isComposite(a, d, n, s) for a in _primes)
    
def g(x, c, n) :
    return (x * x + c) % n
    
def PollardRho(n) :
    if MillerRabin(n) : return [n]
    if n == 4 : return [2, 2]
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
    for i in sorted(PollardRho(int(input()))):
        print(i)
