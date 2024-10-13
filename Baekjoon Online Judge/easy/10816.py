from bisect import bisect_left, bisect_right
from sys import stdin
input = stdin.readline

'''
def lower_bound(arr, target):
    left, right = 0, len(arr)
    while left < right:
        mid = (left + right) // 2
        if arr[mid] < target:
            left = mid + 1
        else:
            right = mid
    return left

def upper_bound(arr, target):
    left, right = 0, len(arr)
    while left < right:
        mid = (left + right) // 2
        if arr[mid] <= target:
            left = mid + 1
        else:
            right = mid
    return left
'''

if __name__ == '__main__':
    res = []

    # Input
    input()
    arr = [*map(int, input().split())]
    M = int(input())
    target_list = [*map(int, input().split())]

    # Solve
    cnt = [0] * M
    arr.sort()
    for idx, target in enumerate(target_list):
        cnt[idx] = bisect_right(arr, target) - bisect_left(arr, target)

    # Output
    print(*cnt)
    
