'''
https://www.codetree.ai/missions/2/problems/tromino?&utm_source=clipboard&utm_medium=text
'''

if __name__ == '__main__':
    # Input
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

    # Solve
    res = 0
    for i in range(N):
        for j in range(M):
            if j + 1 < M:
                temp = board[i][j] + board[i][j + 1]
                if j + 2 < M:
                    res = max(res, temp + board[i][j + 2])
                if i + 1 < N:
                    res = max(res, temp + max(board[i + 1][j], board[i + 1][j + 1]))
            if i + 1 < N:
                temp = board[i][j] + board[i + 1][j]
                if i + 2 < N:
                    res = max(res, temp + board[i + 2][j])
                if j - 1 >= 0:
                    res = max(res, temp + board[i + 1][j - 1])
                if j + 1 < M:
                    res = max(res, temp + board[i + 1][j + 1])

    # Output
    print(res)
