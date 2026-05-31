from sys import stdin

input=stdin.readline


def calc(x):
    total = 0
    for a in A:
        total += min(a, x)
    return total >= T


def solve():
    left, right = 0, T
    answer = T

    while left <= right:
        mid = (left + right) // 2

        if calc(mid):
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer


if __name__ == '__main__':
    # Input
    N, T = map(int, input().split())
    A = [*map(int, input().split())]

    # Solve
    print(solve())