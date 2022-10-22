from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    wall = [[*map(int, input().split())] for _ in range(N)]
    move = [[[0] * N for _ in range(N)] for _ in range(3)]
    move[0][0][1] = 1
    for i in range(2, N) :
        if not wall[0][i] :
            move[0][0][i] = move[0][0][i - 1]
    for i in range(1, N) :
        for j in range(2, N) :
            if not wall[i][j] :
                move[0][i][j] = move[0][i][j - 1] + move[2][i][j - 1]
                move[1][i][j] = move[1][i - 1][j] + move[2][i - 1][j]
                if not wall[i - 1][j] and not wall[i][j - 1] :
                    move[2][i][j] = sum(move[k][i - 1][j - 1] for k in range(3))
    print(sum(move[k][N - 1][N - 1] for k in range(3)))
