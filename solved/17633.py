from collections import Counter
from random import randint
from math import gcd, sqrt

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
    def fourSquare(n) :     # Legendre's three-square theorem
        while n % 4 == 0 : n //= 4
        return n % 8 == 7
        
    def three_square(n):    #Fermat's theorem on sums of two squares
        for i, n in list(Counter(PollardRho(n)).items()) :
            if i % 4 == 3 and n % 2 == 1 :
                return True
        return False
    
    n = int(input())
    if fourSquare(n) : print(4)
    elif three_square(n) : print(3)
    elif pow(int(sqrt(n)), 2) != n : print(2)
    else : print(1)
