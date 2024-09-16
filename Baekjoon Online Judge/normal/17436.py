from itertools import combinations
from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())
    prime_list = [*map(int, input().split())]

    # Solve
    res = 0
    for i in range(1, N + 1):
        for comb in combinations(prime_list, i):
            lcm = 1
            for p in comb:
                lcm *= p
                if lcm > M:
                    break
            else:
                if i % 2 == 1:
                    res += M // lcm
                else:
                    res -= M // lcm

    # Output
    print(res)
