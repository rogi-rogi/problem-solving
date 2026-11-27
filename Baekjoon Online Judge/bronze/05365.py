if __name__ == '__main__':
    N = int(input())
    words = input().split()
    res = [words[0][0]]
    prev_size = len(words[0])
    for word in words[1:]:
        if len(word) >= prev_size:
            res.append(word[prev_size - 1])
        else:
            res.append(" ")
        prev_size = len(word)
    print(*res, sep='')
