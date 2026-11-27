def upperBound(arr, val) :
    min_height = 0
    max_height = arr[-1]
    while min_height < max_height :
        mid = (min_height + max_height) // 2
        temp_sum = 0
        for i in arr :
            diff = i - mid
            if diff > 0 : temp_sum += diff
        if temp_sum < val : max_height = mid
        else : min_height = mid + 1
    return min_height - 1
        
N, M = map(int, input().split())
print(upperBound(sorted(list(map(int, input().split()))), M))
