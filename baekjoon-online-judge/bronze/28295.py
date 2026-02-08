nums = [0] * 4
for _ in range(10) :
    nums[int(input())] += 1
print("NESW"[(nums[1] + nums[2] * 2 + nums[3] * 3) % 4])
