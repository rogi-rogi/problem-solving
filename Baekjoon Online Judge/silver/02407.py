from math import factorial

def combination(n, k) :
    return factorial(n) // ( factorial(k) * factorial(n - k) )

print(combination(*map(int, input().split())))
