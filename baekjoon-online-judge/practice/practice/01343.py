S = input().replace("XXXX", "AAAA").replace("XX", "BB")
print(-1 if 'X' in S else S)

'''
EMPTY = 'X'

if __name__ == '__main__':
    S = [*input().rstrip()]
    idx = 0
    while idx < len(S):
        if S[idx] == EMPTY:
            if idx + 1 < len(S) and S[idx + 1] == EMPTY:
                if idx + 3 < len(S) and S[idx + 2] == S[idx + 3] == EMPTY:
                    for i in range(idx, idx + 4):
                        S[i] = 'A'
                    idx += 2
                else:
                    S[idx] = S[idx + 1] = 'B'
                idx += 2
        else:
            idx += 1
    print(-1 if EMPTY in S else ''.join(S))
'''
