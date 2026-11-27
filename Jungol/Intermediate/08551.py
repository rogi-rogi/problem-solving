from sys import stdin

input=stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    A = [*map(int, input().split())]
    X, Y = map(int, input().split())

    # Solve
    sub_sorted_a = A[:X] + sorted(A[X:Y + 1]) + A[Y+1:]
    A.sort()

    # Output
    print(*sub_sorted_a)
    print(*A)