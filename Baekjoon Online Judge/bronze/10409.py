if __name__ == '__main__':
    N, T = map(int, input().split())
    nums = [*map(int, input().split())]
    temp = 0
    cnt = 0
    for num in nums:
        temp += num
        if temp > T:
            break
        cnt += 1
    print(cnt)
