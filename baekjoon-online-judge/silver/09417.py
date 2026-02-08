from math import gcd

for _ in range(int(input())) :
    nums = list(map(int, input().split()))
    result = []
    for i in range(len(nums)) :
        for j in range(i + 1, len(nums)) :
            result.append(gcd(max(nums[i], nums[j]), min(nums[i], nums[j])))
    print(max(result))
