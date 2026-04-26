from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    A = [[*map(int, input().split())] for _ in range(N)]

    # Solve
    A.sort(key=lambda x: (x[1], x[0]))

    # Output
    for x, y in A:
        print(x, y)