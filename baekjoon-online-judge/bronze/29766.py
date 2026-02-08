line = input()
size = len(line)
idx, cur = 0, 0
cnt = 0
while idx < size :
    if line[idx] == "DKSH"[cur] :
        cur += 1
        if cur == 4 :
            cur = 0
            cnt += 1
    elif line[idx] == "D" :
        cur = 1
    else :
        cur = 0
    idx += 1
print(cnt)
