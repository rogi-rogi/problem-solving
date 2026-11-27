nums = [i + 1 for i in range(int(input()))]
cycle = 1
k = 0
while len(nums) > 1 :
    idx = (cycle**3 - 1 + k)% len(nums)
    del nums[idx]
    cycle += 1
    k = idx
print(nums[0])
