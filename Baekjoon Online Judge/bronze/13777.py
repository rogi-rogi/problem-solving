def binarySearch(val) :
    left = 1
    right = 50
    result = []
    while left <= right :
        mid = (left + right) // 2
        result.append(mid)
        if mid == val : return result
        if val < mid : right = mid - 1
        else : left = mid + 1  
    
while True :
    num = int(input())
    if num == 0 : break
    print(*binarySearch(num))
