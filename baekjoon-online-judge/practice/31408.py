N = int(input())
nums = [*map(int, input().split())]
half = (len(nums) + 1) // 2
res = "YES"
count = [0] * 100001
for num in nums :
    count[num] += 1
for i in range(1, 100001) :
    if count[i] > half :
        res = "NO"
        break
print(res)
