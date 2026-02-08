from bisect import bisect_left
from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N, C = map(int, input().split())
    arr = sorted([*map(int, input().split())])

    # Solve
    res = 0
    for c in arr:
        if c == C:
            print(1)
            exit(0)
    for i in range(N - 1):
        for j in range(i + 1, N):
            temp = C - arr[i] - arr[j]
            if temp == 0:
                print(1)
                exit(0)
            elif temp < 0:
                break
            it = bisect_left(arr, temp, j + 1)
            if it < len(arr) and arr[it] == temp:
                print(1)
                exit(0)

    # Output
    print(0)
