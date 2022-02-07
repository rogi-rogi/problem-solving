from sys import stdin
    
if __name__ == "__main__" :
    N, M, T = map(int, stdin.readline().split())
    board = [list(map(int, stdin.readline().split())) for _ in range(N)]
    clean_bot = [(i, j) for i in range(N) if board[i][0] == - 1]
    while True :
        spread()
        clear()
    
        
    total = 0
    for i in range(N) :
        total += sum(board[i])
