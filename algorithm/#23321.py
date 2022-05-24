board = []
for _ in range(5) :
    board.append(list(input()))
for i in range(len(board[0])) :
    if board[0][i] == 'o' :
        for j in range(5) : board[j][i] = str(".omln"[j])
    elif board[1][i] == 'o' :
        for j in range(5) : board[j][i] = str("owln."[j])
for i in board :
    print(*i, sep = '')
