from sys import stdin
    
if __name__ == "__main__" :
    N, M, T = map(int, stdin.readline().split())
    board = [list(map(int, stdin.readline().split())) for _ in range(N)]
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    clean_bot = []
    for row in range(N) :
        if board[row][0] == -1 :
            clean_bot.append(row)
    sec = 0
    while True :
        temp = [[0] * M for _ in range(N)]
        for i in range(N) :
            for j in range(M) :
                if board[i][j] > 4 :
                    cnt = 0
                    for d in range(4) :
                        nx = i + dx[d]
                        ny = i + dy[d]
                        if 0 <= nx < N and 0 <= ny < M and board[nx][ny] != -1 :
                            temp[nx][ny] += board[i][j] // 5
                            cnt += 1
                        temp[i][j] += board[i][j] - (board[i][j] // 5) * cnt
        board = temp[:]
        for i in range(1, -2, -2) :
            d = 0 if i == 1 else 2
            x = clean_bot[i], y = 0
            while True :
                nx = x + dx[d]
                ny = y + dy[d]
                if 0 <= nx < N and 0 <= ny < M :
                    if board[nx][ny] == -1 : board[nx][ny] = 0
                    else : board[x][y] = board[nx][ny]
                else : d = (d + 4 + i) % 4
        sec += 1
        if sec == T :
            total = 0
            for i in range(N) :
                total += sum(board[i])
            print(total)
            break
    
            
