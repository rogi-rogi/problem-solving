from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    while True:
        res = 0
        nums = [*map(int, input().split())]

        # Solve
        if sum(nums) == 0:
            break
        if nums[3] == 0:
            nums[3] = nums[0] * nums[1] * nums[2]
        else:
            for i in range(3):
                if nums[i] == 0:
                    nums[i] = 1
                    nums[i] = nums[3] // (nums[0] * nums[1] * nums[2])
                    break
        # Output
        print(*nums)
