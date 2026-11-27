from sys import stdin
input = stdin.readline

def isInArea(x, y) :
    return (0 <= x < N and 0 <= y < M)
    
def clean(x, y, d):
    cnt = 0
    if board[x][y] == 0:
        board[x][y] = -1    #(1)
        cnt += 1
    for _ in range(4) : 
        d = (d + 3) % 4     #(2)
        nx = x + D[d][0] 
        ny = y + D[d][1]
        if isInArea(nx, ny) and board[nx][ny] == 0 :  #(2) - (a)
            return cnt + clean(nx, ny, d)
        #(2) - (b)
    #(2) - (c)
    nx = x - D[d][0]
    ny = y - D[d][1]
    if isInArea(nx, ny) : 
        return cnt + (0 if board[nx][ny] == 1 else clean(nx, ny, d)) #(2) - (d)
        
if __name__ == "__main__" :
    N, M = map(int, input().split())
    D = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    x, y, d = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    print(clean(x, y, d))
