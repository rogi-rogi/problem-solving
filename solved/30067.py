nums = [int(input()) for _ in range(10)]
temp = sum(nums)
for num in nums :
    if num == temp - num :
        print(num)
        break
