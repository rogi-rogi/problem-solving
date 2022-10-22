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
    while True :
        try : N = int(input())
        except : break
        print(EulerPhi(int(N)) // 2)
    
