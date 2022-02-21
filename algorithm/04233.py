from sys import stdin

def isPrime(n) :
    p = 2
    while p * p <= n :
        if n % p == 0 : return False
        p += 1
    return True

if __name__ == "__main__" :
    while True :
        p, a = map(int, stdin.readline().split())
        if p == a == 0 :
            break
        if isPrime(p) : print("no")
        elif pow(a, p, p) == a : print("yes")
        else : print("no")
        
