from sys import stdin

input = stdin.readline

if __name__ == '__main__':

    # Input
    A = [*map(int, input().split())]

    # Solve
    A.sort()
    for i in range(10):
        A[i] += 1

    # Output
    print(*A)