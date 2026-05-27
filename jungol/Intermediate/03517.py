from sys import stdin

input=stdin.readline


def binary_search(target):
    left, right = 0, N - 1

    while left <= right:
        mid = (left + right) // 2

        if A[mid] > target:
            right = mid - 1
        elif A[mid] < target:
            left = mid + 1
        else:
            return mid
    return -1


if __name__ == '__main__':
    # Input
    N = int(input())
    A = [*map(int, input().split())]
    input()
    Q = [*map(int, input().split())]

    # Solve & Output
    print(*[binary_search(q) for q in Q])
