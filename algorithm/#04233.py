#default ver
from sys import stdin

def isPrime(n) :
    if n == 2 : return True
    p = 3
    while p * p <= n :
        if n % p == 0 : return False
        p += 2
    return True

if __name__ == "__main__" :
    while True :
        p, a = map(int, stdin.readline().split())
        if p == a == 0 :
            break
        if isPrime(p) : print("no")
        elif pow(a, p, p) == a : print("yes")
        else : print("no")

            
#MillerRabin ver
from sys import stdin

def isComposite(a, d, n, s) :
    if pow(a, d, n) == 1 : return False
    for r in range(s) :
        if pow(a, 2**r*d, n) == n - 1 : return False
    return True

def _MillerRabin(n) :
    d = n - 1
    s = 0
    while d % 2 == 0 :
        d >>= 1
        s += 1
    return not any(isComposite(a, d, n, s) for a in [2, 3, 5, 7, 11, 13, 17, 19])

_primes = [2, 3]
_primes += [n for n in range(5, 1000, 2) if _MillerRabin(n)]

def MillerRabin(n) :
    if n <= 1 : return False
    if n in _primes : return True
    if any(n % p == 0 for p in _primes) : return False
    if n == 3215031751: return False
    return _MillerRabin(n)
    
if __name__ == "__main__" :
    while True :
        p, a = map(int, stdin.readline().split())
        if p == 0 :
            break
        if MillerRabin(p) : print("no")
        elif pow(a, p, p) == a : print("yes")
        else : print("no")
        
