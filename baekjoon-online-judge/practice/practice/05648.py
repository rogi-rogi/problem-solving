from sys import stdin
input = stdin.read

if __name__ == '__main__':
    N, *nums = input().split()
    for i in range(int(N)) :
        nums[i] = nums[i][::-1]
    nums = sorted([*map(int, nums)])
    print(*nums, sep='\n')
