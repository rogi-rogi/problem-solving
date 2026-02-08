def division(i, j, size) :
    if size == 1 : return board[i][j]
    for row in range(i, i + size) :
        for col in range(j, j + size) :
            if board[row][col] != board[i][j] :
                size >>= 1
                planes = [
                    division(i, j, size),
                    division(i, j + size, size),
                    division(i + size, j, size),
                    division(i + size, j + size, size)
                ]
                return '(' + ''.join(planes) + ')'
    return board[i][j]
    
N = int(input())
board = [input() for _ in range(N)]
print(division(0, 0, N))
