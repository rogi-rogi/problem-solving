from sys import stdin

input=stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    A = [*map(int, input().split())]
    X, Y = map(int, input().split())

    # Solve
    sub_reversed_a = A[:X] + A[X:Y+1][::-1] + A[Y+1:]
    A.sort(reverse=True)

    # Output
    print(*sub_reversed_a)
    print(*A)