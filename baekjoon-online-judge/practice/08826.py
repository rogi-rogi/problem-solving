from collections import defaultdict
from sys import stdin
input = stdin.readline

if __name__ == '__main__':

    # Input
    for _ in range(int(input())):
        input()
        S = input().rstrip()

        # Solve
        D = defaultdict(int)
        for s in S:
            D[s] += 1

        # Output
        print(abs(D['N'] - D['S']) + abs(D['W'] - D['E']))
