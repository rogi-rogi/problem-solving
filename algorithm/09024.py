from sys import stdin
input = stdin.readline

def binarySearch(arr) :
    left = 0
    right = n - 1
    cnt = 1
    min_diff = int(1e8)
    while left < right :
        num_sum = arr[left] + arr[right]
        if num_sum == k :
            left += 1
            right -= 1
        elif num_sum < k : left += 1
        else : right -= 1
        
        if abs(k - num_sum) < min_diff :
            min_diff = abs(k - num_sum)
            cnt = 1
        elif abs(k - num_sum) == min_diff : cnt += 1
    return cnt
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        n, k = map(int, input().split())
        print(binarySearch(sorted(list(map(int, input().split())))))
