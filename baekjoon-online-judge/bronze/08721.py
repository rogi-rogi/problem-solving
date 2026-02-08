from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    input()
    nums = [*map(int, input().split())]

    # Solve
    a = 1
    cnt = 0
    for num in nums:
        if a == num:
            a += 1
        else:
            cnt += 1

    # Output
    print(cnt)
