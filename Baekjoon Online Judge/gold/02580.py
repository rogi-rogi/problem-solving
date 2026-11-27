from sys import stdin

input = stdin.readline

def isValid(x, y, val):
    for i in range(9):
        if board[x][i] == val or board[i][y] == val:
            return False
    lu_x, lu_y = (x // 3) * 3, (y // 3) * 3
    for i in range(lu_x, lu_x + 3):
        for j in range(lu_y, lu_y + 3):
            if board[i][j] == val:
                return False
    return True

def bt(n):
    if n == 81:
        return True
    x, y = n // 9, n % 9
    if board[x][y] == 0:
        for val in range(1, 10):
            if isValid(x, y, val):
                board[x][y] = val
                if bt(n + 1):
                    return True
                board[x][y] = 0
        return False
    else:
        return bt(n + 1)

if __name__ == '__main__':
    # Input
    board = [[*map(int, input().split())] for _ in range(9)]

    # Solve
    bt(0)

    # Output
    for i in range(9):
        print(*board[i])