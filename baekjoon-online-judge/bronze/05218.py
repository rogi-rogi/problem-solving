for _ in range(int(input())) :
    words = input().split()
    res = "Distances:"
    for i in range(len(words[0])) :
        res += ' '
        res += str(ord(words[1][i]) - ord(words[0][i]) + (0 if words[1][i] >= words[0][i] else 26))
    print(res)
