from sys import stdin

input=stdin.readline


def f(x):
    total = 0
    for h in H:
        if h > x:
            total += h - x
    return total >= M


def solve():
    left, right = 0, max(H)

    x = 0
    while left <= right:
        mid = (left + right) // 2
        if f(mid):
            x = mid
            left = mid + 1
        else:
            right = mid - 1
    return x


if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())
    H = [*map(int, input().split())]


    # Solve & Output
    print(solve())