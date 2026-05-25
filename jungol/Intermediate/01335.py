from sys import stdin

input = stdin.readline

WHITE = 0
BLUE = 1


def solve():
    stack = [(0, 0, N)]
    answer = [0, 0]

    while stack:
        x, y, n = stack.pop()

        total = 0
        for i in range(x, x + n):
            for j in range(y, y + n):
                total += board[i][j]

        if total == n * n:
            answer[BLUE] += 1
        elif total == 0:
            answer[WHITE] += 1
        else:
            half_n = n // 2
            for dx, dy in [(0, 0), (half_n, 0), (0, half_n), (half_n, half_n)]:
                stack.append((x + dx, y + dy, half_n))
    return answer


if __name__ == '__main__':
    # Input
    N = int(input())
    board = [[*map(int, input().split())] for _ in range(N)]

    # Solve & Output
    print(*solve(), sep='\n')

