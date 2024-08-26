from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    X = [0, *map(int, input().split())]
    T = [0, *map(int, input().split())]

    # Solve
    res = 2 * X[N]
    for i in range(1, N + 1):
        res = max(res, T[i] + X[i])

    # Output
    print(res)
