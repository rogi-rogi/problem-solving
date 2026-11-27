if __name__ == '__main__':
    N = int(input())
    nums = sorted([*map(int, input().split())])
    X = int(input())
    left, right = 0, N - 1
    cnt = 0
    while left < right:
        temp = nums[left] + nums[right]
        if temp < X:
            left += 1
        elif temp > X:
            right -= 1
        else :
            left += 1
            right -= 1
            cnt += 1
    print(cnt)
