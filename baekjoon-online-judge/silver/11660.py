from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())
    board = []
    board.append([0] * (N + 1))
    for _ in range(N):
        board.append([0, *map(int, input().split())])

    # Solve
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1]

    res = []
    for _ in range(M):
        x1, y1, x2, y2 = map(int, input().split())
        res.append(board[x2][y2] - board[x1 - 1][y2] - board[x2][y1 - 1] + board[x1-1][y1 - 1])

    # Output
    print(*res, sep='\n')