from sys import stdin

input = stdin.readline


def f(x):
    count = 1
    last = A[0]

    for pos in A[1:]:
        if pos - last >= x:
            count += 1
            last = pos
            if count >= K:
                return True
    return False


def solve():
    left, right = 1, A[-1] - A[0]
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
    N, K = map(int, input().split())
    A = [int(input()) for _ in range(N)]

    # Solve
    A.sort()

    # Output
    print(solve())