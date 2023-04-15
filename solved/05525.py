N = int(input())
M = int(input())
S = input()
SIZE = (2 * N) + 1
CASE = 'O'.join('I' * (N + 1))

idx, cnt = 0, 0
while idx < M - 1:
    if (idx + SIZE <= M) and S[idx] == 'I':
        for jump in range(1, SIZE) :
            if S[idx + jump] != CASE[jump] :
                idx += jump
                break
        else :
            cnt += 1
            while (idx + SIZE + 1 < M) and (S[idx + SIZE] == 'O' and S[idx + SIZE +1] == 'I') :
                cnt += 1
                idx += 2
            idx += SIZE
    else : idx += 1
print(cnt)
