nums = [*range(1, 21)]
for _ in range(10) :
    a, b = map(int, input().split())
    nums[a-1:b] = nums[a-1:b][::-1]
print(*nums)
