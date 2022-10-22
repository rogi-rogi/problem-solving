N = int(input())
file_names = [input() for _ in range(N)]
result = ""
for j in range(len(file_names[0])) :
    wild_card_char = False
    for i in range(N - 1) :
        if file_names[i][j] != file_names[i + 1][j] :
            wild_card_char = True
            break
    result += '?' if wild_card_char else file_names[0][j]
print(result)
