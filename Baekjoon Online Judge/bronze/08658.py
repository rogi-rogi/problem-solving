from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())

    # Solve
    for i in range(2, N):
        if N % i != 0:
            # Output
            print(i, N - 1)
            break
