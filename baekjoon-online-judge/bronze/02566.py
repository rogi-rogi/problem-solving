nums = [[*map(int, input().split())] for _ in range(9)]
res, row, col = -1, 0, 0
for i in range(9) :
    for j in range(9) :
        if nums[i][j] > res :
            res = nums[i][j]
            row = i + 1
            col = j + 1
print(res)
print(row, col)
