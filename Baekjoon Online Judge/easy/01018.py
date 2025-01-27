from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Init
    res = []

    # Input
    N, M = map(int, input().split())
    board = [input().rstrip() for _ in range(N)]

    # Solve
    res = N * M
    for i in range(N - 7):
        for j in range(M - 7):
            white, black = 0, 0
            for x in range(i, i + 8):
                for y in range(j, j + 8):
                    if (x + y) % 2 == 0:
                        if board[x][y] == 'W':
                            white += 1
                        else:
                            black += 1
                    else:
                        if board[x][y] == 'B':
                            white += 1
                        else:
                            black += 1
            res = min(res, white, black)

    # Output
    print(res)
