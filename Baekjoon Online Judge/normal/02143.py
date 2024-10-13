from bisect import bisect_left, bisect_right
from sys import stdin
input = stdin.readline

def get_prefix_sum(arr):
    prefix_sum = []
    for i in range(len(arr)):
        prefix_sum.append(arr[i])
        for j in range(i + 1, len(arr)):
            prefix_sum.append(prefix_sum[-1] + arr[j])
    return sorted(prefix_sum)


if __name__ == '__main__':
    # Input
    T = int(input())
    N = int(input())
    A = [*map(int, input().split())]
    M = int(input())
    B = [*map(int, input().split())]

    # Solve
    prefix_sum_a = get_prefix_sum(A)
    prefix_sum_b = get_prefix_sum(B)
    cnt = 0
    for a in prefix_sum_a:
        target = T - a
        cnt += bisect_right(prefix_sum_b, target) - bisect_left(prefix_sum_b, target)

    # Output
    print(cnt)
    
