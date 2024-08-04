if __name__ == '__main__':
    N, M = map(int, input().split())
    board = [[*map(int, input().split())] for _ in range(N)]
    '''
    1 1 1

    1 1
      1

    1 1
    1

    1
    1
    1

    1
    1 1

    1
  1 1
    '''
    res = 0
    for i in range(N):
        for j in range(M):
            if j + 2 < M:
                res = max(res, board[i][j] + board[i][j + 1] + board[i][j + 2])
            if j + 1 < M and i + 1 < N:
                res = max(res, board[i][j] + board[i][j + 1] + max(board[i + 1][j], board[i + 1][j + 1]))
            if i + 2 < N:
                res = max(res, board[i][j] + board[i + 1][j] + board[i + 2][j])
            if i + 1 < N:
                if j - 1 >= 0:
                    res = max(res, board[i][j] + board[i + 1][j] + board[i + 1][j - 1])
                if j + 1 < M:
                    res = max(res, board[i][j] + board[i + 1][j] + board[i + 1][j + 1])
    print(res)
