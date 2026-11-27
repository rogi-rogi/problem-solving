from sys import stdin

input = stdin.readline


def lower_bound(target):
    left, right = 0, N

    while left < right:
        mid = (left + right) // 2

        if A[mid] < target:
            left = mid + 1
        else:
            right = mid

    return left


def solve(target):
    idx = lower_bound(target)

    if idx == 0:
        return A[0]

    if idx == N:
        return A[N - 1]

    left_value = A[idx - 1]
    right_value = A[idx]

    if target - left_value <= right_value - target:
        return left_value
    else:
        return right_value


if __name__ == '__main__':
    # Input
    N, Q = map(int, input().split())
    A = [*map(int, input().split())]
    B = [int(input()) for _ in range(Q)]

    # Solve
    answer = [solve(b) for b in B]

    # Output
    print(*answer, sep='\n')

