from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Init
    res = []

    # Input
    height = sorted([int(input()) for _ in range(9)])

    # Solve
    diff = sum(height) - 100
    for i in range(8):
        for j in range(i + 1, 9):
            if height[i] + height[j] == diff:
                res = [height[k] for k in range(9) if k != i and k != j]

    # Output
    print(*res, sep='\n')
