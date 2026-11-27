from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    H = [int(input()) for _ in range(N)]

    # Solve
    answer = [0] * N
    stack = []

    i = N - 1
    for h in reversed(H):
        while stack and H[stack[-1]] <= h:
            stack.pop()

        if stack:
            answer[i] = stack[-1] + 1
        stack.append(i)
        i -= 1

    # Output
    print(*answer, sep='\n')