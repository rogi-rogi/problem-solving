if __name__ == '__main__':
    S = input()
    alpha = [0] * 26
    for s in S:
        alpha[ord(s) - 65] += 1
    odd_count = sum([1 for i in range(26) if alpha[i] % 2 == 1])
    res = [''] * len(S)
    if len(S) % 2 == 0 and odd_count > 0:
        res = "I'm Sorry Hansoo"
    elif len(S) % 2 == 1 and odd_count > 1:
        res = "I'm Sorry Hansoo"
    else:
        alpha_idx = 0
        for i in range(len(S) // 2):
            while alpha[alpha_idx] < 2:
                alpha_idx += 1
            res[i] = res[len(S) - i - 1] = chr(alpha_idx + 65)
            alpha[alpha_idx] -= 2
            if alpha[alpha_idx] <= 1:
                alpha_idx += 1
        if odd_count == 1:
            res[len(S)//2] = chr(alpha.index(1) + 65)
    print(''.join(res))
