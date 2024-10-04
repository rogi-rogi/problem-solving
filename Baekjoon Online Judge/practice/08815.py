from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    S = "BCBCDCDADABA"

    # Input
    for _ in range(int(input())):
        N = int(input())

        # Solve & Output
        print('A' if N == 1 else S[(N - 2) % 12])
