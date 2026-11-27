from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    H = [*map(int, input().split())]

    # Solve
    answer = [0] * N
    stack = []
    for i, h in enumerate(H):
        while stack and stack[-1][1] < h:  # last_h <= cur_h
            stack.pop()
        if stack:
            answer[i] = stack[-1][0] + 1
        stack.append((i, h))

    # Output
    print(*answer)