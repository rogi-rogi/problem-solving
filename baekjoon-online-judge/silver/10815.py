def binarySearch(arr, val, N) :
    left = 0
    right = N - 1
    while left <= right :
        mid = (left + right) // 2
        if arr[mid] == val : return 1
        if val < arr[mid] : right = mid - 1
        else : left = mid + 1
    return 0
    
N = int(input())
A = sorted(list(map(int, input().split())))
input()
result = []
for i in list(map(int, input().split())) :
    result.append(binarySearch(A, i, N))
print(*result)
