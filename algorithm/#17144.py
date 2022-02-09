from sys import stdin
    
if __name__ == "__main__" :
    N, M, T = map(int, stdin.readline().split())
    board = [list(map(int, stdin.readline().split())) for _ in range(N)]
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    clean_bot = []
    for row in range(N) :
        if board[row][0] == -1 :
            clean_bot.extend([row, row + 1])
            break
    sec = 0
    
    while True :
        temp = [[0] * M for _ in range(N)]
        for x in range(N) :
            for y in range(M) :
                if board[x][y] > 4 :
                    cnt = 0
                    for d in range(4) :
                        nx = x + dx[d]
                        ny = y + dy[d]
                        if 0 <= nx < N and 0 <= ny < M and board[nx][ny] != -1 :
                            temp[nx][ny] += board[x][y] // 5
                            cnt += 1
                    temp[x][y] += board[x][y] - (board[x][y] // 5) * cnt
                else : temp[x][y] += board[x][y]
        board = temp[:]
        for i in range(2) :
            x = clean_bot[i]
            y = 0
            if i == 0 :
                d = 0
                rows = [0, clean_bot[i] + 1]
            else :
                d = 2
                rows = [clean_bot[i], N]
            while True :
                nx = x + dx[d]
                ny = y + dy[d]
                if rows[0] <= nx < rows[1] and  0 <= ny < M :
                    if board[nx][ny] == -1 :
                        board[x][y] = 0
                        break
                    if board[x][y] == -1 : board[nx][ny] = 0
                    else : board[x][y] = board[nx][ny]
                    x = nx
                    y = ny
                else :
                    d = (d + 1) if i == 0 else (d + 3) % 4
        sec += 1
        if sec == T :
            total = 0
            for i in range(N) :
                total += sum(board[i])
            print(total + 2)
            break
