from copy import deepcopy
from sys import stdin
input = stdin.readline

def select(select_area, val) :
    if select_area == 0 :       return 0, val
    elif select_area == val :   return 1, val * 2
    else :                      return 1, val
        
def move(board, d) :
    if d == 0 or d == 2 : start, end, gap, op = 1, N, 1, 1
    else :                start, end, gap, op = N - 2, -1, -1, -1
    if d == 0 or d == 1:     #up, down
        for j in range(N) :
            idx = 0 if d == 0 else (N - 1) 
            for i in range(start, end, gap) :
                if board[i][j] :
                    temp, board[i][j] = board[i][j], 0
                    jump, val = select(board[idx][j], temp)
                    if val != temp : board[idx][j] = val
                    else : board[idx + op * jump][j] = val
                    idx += op * jump
    elif d == 2 or d == 3 :   #left, right
        for i in range(N) :
            idx = 0 if d == 2 else (N - 1) 
            for j in range(start, end, gap) :
                if board[i][j] :
                    temp, board[i][j] = board[i][j], 0
                    jump, val = select(board[i][idx], temp)
                    if val != temp : board[i][idx] = val
                    else : board[i][idx + op * jump] = val
                    idx += op * jump
    return board
    
def dfs(board, cnt) :
    if cnt == 5 : 
        global result
        result = max(result, max(map(max, board)))
    else :
        for i in range(4) :
            dfs(move(deepcopy(board), i), cnt + 1)
            
if __name__ == "__main__" :
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    result = 0
    dfs(board, 0)
    print(result)
