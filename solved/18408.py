nums = [*map(int, input().split())]
print([2, 1][nums.count(1) > nums.count(2)])
