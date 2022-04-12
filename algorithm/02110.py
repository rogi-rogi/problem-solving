from sys import stdin
input = stdin.readline

def isPossible(arr, val) : #mid 이상의 거리를 가지는 공유기의 cnt
    cnt = 1
    temp = arr[0]
    for i in arr[1:] :
        if i - temp >= val :
            cnt += 1
            temp = i
    return True if cnt >= C else False

def binarySearch(arr) :
    left = 1
    right = arr[-1] - arr[0]
    result = 0
    while left <= right :
        mid = (left + right) // 2
        if isPossible(arr, mid) :
            result = max(result, mid)
            left = mid + 1
        else : right = mid - 1
    return result
    
if __name__ == "__main__" :
    N, C = map(int, input().split())
    print(binarySearch(sorted([int(input()) for _ in range(N)])))
