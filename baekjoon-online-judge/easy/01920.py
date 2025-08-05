from sys import stdin
input = stdin.readline

def binary_search(arr, target):
    left, right = 0, len(arr) - 1

    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return 1
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return 0

if __name__ == '__main__':
    # Input
    input()
    arr = sorted(map(int, input().split()))
    input()
    
    res = []
    for target in map(int, input().split()):
        # Solve
        res.append(binary_search(arr, target))
    
    # Output
    print(*res, sep='\n')
    
