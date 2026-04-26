from sys import stdin

input = stdin.readline

def bt(row):
    if row == N:
        global res
        res += 1
        return

    for col in range(N):
        for prev in range(row):
            if board[prev] == col or abs(col - board[prev]) == row - prev:
                break
        else:
            board[row] = col
            bt(row + 1)



if __name__ == '__main__':
    # Input
    N = int(input())

    # Solve
    board = [0] * N
    res = 0
    bt(0)

    # Output
    print(res)