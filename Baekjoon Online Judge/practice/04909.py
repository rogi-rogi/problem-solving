while True :
    nums = [*map(int, input().split())]
    if sum(nums) == 0 : break
    score = sum(sorted(nums)[1:-1])
    print([score / 4, score // 4][score / 4 % 1 == 0])
