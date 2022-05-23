cnt_alpha = [0] * 26
S = input()
for i in range(26) :
    cnt_alpha[i] = S.count(chr(ord('a') + i))
print(*cnt_alpha, sep = ' ')
