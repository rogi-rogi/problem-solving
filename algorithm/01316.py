cnt = 0
for _ in range(int(input())) :
    group = [False] * 26
    word = input()
    cnt += 1
    group[ord(word[0]) - 97] = True
    for idx in range(1, len(word)) :
        idx_g = ord(word[idx]) - 97
        if word[idx - 1] != word[idx] and group[idx_g] :
            cnt -= 1
            break
        else : group[idx_g] = True
print(cnt)

# simple ver.
cnt = 0
for _ in range(int(input())):
    word = input()
    if list(word) == sorted(word, key=word.find):
        cnt += 1
print(result)
