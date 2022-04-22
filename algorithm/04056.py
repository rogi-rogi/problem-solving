#pypy3
from sys import stdin
input = stdin.readline

def printBoard(board) :
    for i in range(9) :
        print(*board[i], sep = '')
    print()
    return 0
    
def check(x, y, val, board) :
    row = [0] * 10
    col = [0] * 10
    for i in range(9) :
        row[board[i][y]] += 1
        col[board[x][i]] += 1
    if row[val] > 0 or col[val] > 0 : #가로/세로선에 대입하려는 값과 동일한 숫자가 1개 이상 존재
        return -1
    for i in range(1, 10) : #가로/세로선에 서로 같은 숫자가 2개 이상 존재
        if row[i] > 1 or col[i] > 1 : return -1
    x = (x // 3) * 3
    y = (y // 3) * 3
    nums = [0] * 10
    for i in range(x, x + 3) : 
        for j in range(y, y + 3) : #블럭 안에 대입하려는 값과 동일한 숫자가 존재
            if board[i][j] == val : return -1
            nums[board[i][j]] += 1
    for i in range(1, 9) : #블럭안에 서로 같은 숫자가 2개 이상 존재
        if nums[i] > 1 : return -1
    return 0 #위의 조건을 모두 통과하면 모순이 없다.

def BT(N, board) :
    if N == 81 : return printBoard(board)
    x = N // 9
    y = N % 9
    if board[x][y] == 0 :
        for val in range(1, 10) :
            if check(x, y, val, board) == 0 :
                board[x][y] = val
                if BT(N + 1, board) == 0 : return 0
                board[x][y] = 0
        return -1
    else : return BT(N + 1, board)

if __name__ == "__main__" :
    for _ in range(int(input())) :
        if BT(0, [list(map(int, input().rstrip())) for _ in range(9)]) == -1 :
            print("Could not complete this grid.\n")
