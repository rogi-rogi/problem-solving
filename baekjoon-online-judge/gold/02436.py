from math import *
from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    GCD, LCM = map(int, input().split())

    # Solve
    K = LCM // GCD
    x, y = 0, 0
    for d in range(1, int(K**0.5) + 1):
        if K % d == 0 and gcd(d, K // d) == 1:
            x = d
            y = K // d

    # Output
    print(GCD * x, GCD * y)
