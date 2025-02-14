from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    res = 0
    # Input
    for _ in range(int(input())):
        # Solve
        nums = [*map(int, input().split())]
        res += max(nums) if max(nums) > 0 else 0

    # Output
    print(res)
