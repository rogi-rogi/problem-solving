from math import *
from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    A = [*map(int, input().split())]
    K = int(input())

    # Solve
    gap = 2
    for _ in range(int(log2(N / K))):
        for j in range(0, N, gap):
            A[j:j + gap] = sorted(A[j:j + gap])
        gap <<= 1

    # Output
    print(" ".join(map(str, A)))