for TC in range(1, int(input()) + 1):
    input()
    nums = [*map(int, input().split())]
    print(f"#{TC} {max(nums) - min(nums)}")
