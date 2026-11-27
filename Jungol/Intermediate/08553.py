from sys import stdin

input = stdin.readline


def priority(x):
    return (x % 10, (x % 100) // 10, x // 100)


if __name__ == '__main__':
    # Input
    nums = [int(input()) for __ in range(int(input()))]

    # Solve
    nums.sort(key=priority)

    # Output
    print(*nums, sep='\n')