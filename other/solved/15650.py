from itertools import combinations

if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())

    # Solve
    res = list(combinations(range(1, N + 1), M))

    # Output
    for line in res:
        print(*line)