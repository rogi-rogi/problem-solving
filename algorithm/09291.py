from sys import stdin
input = stdin.readline

def blockCheck(x, y, board) :
    nums = [0] * 10
    for i in range(x, x + 3) : 
        for j in range(y, y + 3) :
            nums[board[i][j]] += 1
            if nums[board[i][j]] > 1 : return -1
    return 0

def lineCheck(x, y, board) :
    row = [0] * 10
    col = [0] * 10
    for i in range(9) :
        row[board[i][y]] += 1
        col[board[x][i]] += 1
        if row[board[i][y]] > 1 or col[board[x][i]] > 1 : return -1
    return 0
    
if __name__ == "__main__" :
    T = int(input())
    for t in range(T) :
        board = [list(map(int, input().split())) for _ in range(9)]
        INCORRECT = 0
        for i in range(0, 7, 3) :
            for j in range(0, 7, 3) :
                if blockCheck(i, j, board) == -1 : INCORRECT = 1
        for i in range(0, 9) :
            for j in range(0, 9) :
                if lineCheck(i, j, board) == -1 : INCORRECT = 1
        print(f"Case {t + 1}:", "CORRECT" if INCORRECT == 0 else "INCORRECT")
        if t < T - 1 : input()
