from sys import stdin

input = stdin.readline

def solve():
    A.sort()
    if N % 2 == 1:
        return [A[N // 2]]
    else:
        return sorted(set([A[N // 2 - 1], A[N // 2]]))

if __name__ == '__main__':

    # Input
    N = int(input())
    A = [*map(int, input().split())]

    # Solve
    A.sort()

    # Output
    print(*solve())