from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, Q = map(int, input().split())
    A = set(map(int, input().split()))
    B = [*map(int, input().split())]

    # Solve
    answer = [b for b in B if b not in A]

    # Output
    if answer:
        print(*answer)
    else:
        print(-1)