from sys import stdin
input=stdin.readline


if __name__ == '__main__':
    board = [[0] * 100 for _ in range(100)]
    
    for _ in range(int(input())):
        x, y = map(int, input().split())
        
        for row in range(y, y + 10):
            for col in range(x, x + 10):
                board[row][col] = 1
    
    print(sum(map(sum, board)))
