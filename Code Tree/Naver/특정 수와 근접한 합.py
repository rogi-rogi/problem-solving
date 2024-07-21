if __name__ == '__main__':
    N, S = map(int, input().split())
    nums = [*map(int, input().split())]
    total = sum(nums)
    res = int(1e9)
    for i in range(N - 1):
        for j in range(i + 1, N):
            res = min(res, abs(total - nums[i] - nums[j] - S))
    print(res)
