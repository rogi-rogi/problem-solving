chess_pieces = [1, 1, 2, 2, 2, 8]
temp = list(map(int, input().split()))
for i in range(6) :
    print(chess_pieces[i] - temp[i], end = ' ')
