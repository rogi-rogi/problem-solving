from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())

    # Solve
    res = 0
    rope_list = sorted([int(input()) for _ in range(N)], reverse=True)
    for idx, rope  in enumerate(rope_list):
        res = max(res, rope * (idx + 1))

    # Output
    print(res)
