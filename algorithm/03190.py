from collections import deque
from sys import stdin
input = stdin.readline

def isAreaOver(x, y) :
    return not (0 <= x < N and 0 <= y < N)
    
def move() :
    d = 1
    sec = 1
    x = y = 0
    visited = deque([(x,y)])
    board[x][y] = -1
    while True :
        x = x + D[d][0]
        y = y + D[d][1]
        if not isAreaOver(x, y) and board[x][y] != -1 :
            if board[x][y] == 0 :   # no apple
                tail_x, tail_y = visited.popleft()
                board[tail_x][tail_y] = 0
            board[x][y] = -1
            visited.append((x,y))
            if sec in turns.keys() :
                d = (d + 3) % 4 if turns[sec] == 'L' else (d + 1) % 4
            sec += 1
        else : return sec
            
if __name__ == "__main__" :
    N = int(input())
    board = [[0] * N for _ in range(N)]
    for _ in range(int(input())) :
        x, y = map(int, input().split())
        board[x - 1][y - 1] = 1
    turns = dict()
    for _ in range(int(input())) :
        X, C = input().split()
        turns[int(X)] = C
    D = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    print(move())
