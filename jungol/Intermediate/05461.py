from sys import stdin

input=stdin.readline


def f(x):
    count, total = 1, 0

    for a in A:
        if total + a <= x:
            total += a
        else:
            count += 1
            total = a
    return count <= M


def solve():
    left, right = max(A), sum(A)
    answer = right

    while left <= right:
        mid = (left + right) // 2

        if f(mid):
            right = mid - 1
            answer = mid
        else:
            left = mid + 1
    return answer


if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())
    A = [*map(int, input().split())]

    # Solve & Output
    print(solve())