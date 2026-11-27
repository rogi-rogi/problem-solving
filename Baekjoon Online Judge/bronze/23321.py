board = [[*input()] for _ in range(5)]
for i in range(len(board[0])) :
    if board[0][i] == 'o' :
        for j in range(5) : board[j][i] = str(".omln"[j])
    elif board[1][i] == 'o' :
        for j in range(5) : board[j][i] = str("owln."[j])
for i in range(5) :
    print(*board[i], sep = '')
