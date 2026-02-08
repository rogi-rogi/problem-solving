from sys import stdin
input = stdin.readline

def EulerPhi(n) :
    euler = n
    prime = 2
    while prime * prime <= n :
        if n % prime == 0:
            euler -= euler // prime
            while n % prime == 0 : n //= prime
        prime += 1
    return euler if n == 1 else euler - euler // n
  
if __name__ == "__main__" :
    x = 1
    result = int(1e9)
    n = int(input())
    while x * x <= n :
        if n % x == 0 :
            if EulerPhi(x) == n // x : result = min(result, x)
            if EulerPhi(n // x) == x : result = min(result, n // x)
        x += 1
    print(result if result != int(1e9) else -1)
    
