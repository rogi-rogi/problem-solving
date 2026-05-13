from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    C = [int(input()) for _ in range(N)]

    # Solve
    answer = 0
    stack = []

    for c in C:
        while stack and stack[-1] <= c:
            stack.pop()

        answer += len(stack)
        stack.append(c)

    # Output
    print(answer)