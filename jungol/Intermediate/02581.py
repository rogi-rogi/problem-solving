from sys import stdin

input = stdin.readline


def f(x):
    total = 0
    for a in A:
        total += min(a, x)
    return total <= M


def solve():
    left, right = 0, max(A)
    answer = 0

    while left <= right:
        mid = (left + right) // 2

        if f(mid):
            left = mid + 1
            answer = mid
        else:
            right = mid - 1

    return answer


if __name__ == '__main__':
    # Input
    N = int(input())
    A = [*map(int, input().split())]
    M = int(input())

    # Solve & Output
    print(solve())