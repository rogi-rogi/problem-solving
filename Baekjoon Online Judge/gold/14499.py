from sys import stdin

if __name__ == "__main__" :
    N, M, X, Y, K = map(int, stdin.readline().split())
    board = [list(map(int, stdin.readline().split())) for _ in range(N)]
    moves = list(map(int, stdin.readline().split()))
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    dice = [0] * 6
    roll = [2, 1, 4, 3]
    for move in moves :
        nx = X + dx[move - 1]
        ny = Y + dy[move - 1]
        if 0 <= nx < N and 0 <= ny < M :
            X = nx
            Y = ny
            dice[0], dice[move], dice[5], dice[roll[move - 1]] = dice[roll[move - 1]], dice[0], dice[move], dice[5]
            if board[X][Y] == 0 :
                board[X][Y] = dice[5]
            else :
                dice[5] = board[X][Y]
                board[X][Y] = 0
            print(dice[0])
