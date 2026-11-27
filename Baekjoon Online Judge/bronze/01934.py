from math import *
from sys import stdin

def lcm(a, b):
    return int(a * b / gcd(a, b))

if __name__ == '__main__':
    res = []

    # Input & Solve
    for _ in range(int(input())):
        A, B = map(int, input().split())
        res.append(lcm(A, B))

    # Output
    print(*res, sep='\n')
