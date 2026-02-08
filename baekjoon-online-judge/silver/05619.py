from sys import stdin

n = int(stdin.readline())
a = sorted([int(stdin.readline().rstrip()) for _ in range(n)])
a = a[:4]
nums = []
for num in a :
    for other_num in a :
        if num != other_num :
            nums.append(int(str(num) + str(other_num)))
print(sorted(nums)[2])
