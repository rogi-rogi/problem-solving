#pypy3
from sys import stdin
input = stdin.readline

def printBoard(board) :
    for i in range(9) :
        print(*board[i], sep = '')
    return 0

def check(x, y, val, board) :
    for i in range(9) :
        if board[x][i] == val or board[i][y] == val :
            return -1
    x = (x // 3) * 3
    y = (y // 3) * 3
    for i in range(x, x + 3) :
        for j in range(y, y + 3) :
            if board[i][j] == val : return -1
    return 0

def BT(N, board) :
    if N == 81 :
        return printBoard(board)
    x = N // 9
    y = N % 9
    if board[x][y] == 0 :
        for val in range(1, 10) :
            if check(x, y, val, board) == 0 :
                board[x][y] = val
                if BT(N + 1, board) == 0 : return 0
                board[x][y] = 0
    else :
        return BT(N + 1, board)

if __name__ == "__main__" :
    BT(0, [list(map(int, input().rstrip())) for _ in range(9)])
