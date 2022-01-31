from sys import stdin
N = int(stdin.readline())
cnt, isGroup = 0, 1
for _ in range(N) :
    word = stdin.readline()
    for idx in range(1, len(word)-1) :
        if word[idx - 1] != word[idx] and word[idx - 1] in word[idx:] :
            isGroup = 0;
    if isGroup == 1 : cnt += 1
    else : isGroup = 1
print(cnt)
