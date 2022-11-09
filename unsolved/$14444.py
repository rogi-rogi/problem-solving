def Manacher(s) :
    s = '#' + '#'.join(s) + '#'
    SIZE = len(s)
    r, c = 0, 0
    R = [0] * SIZE
    for i in range(SIZE) :
        if i <= r : R[i] = min(r - i, R[c + c - i])
        while (0 <= i - R[i] - 1 and i + R[i] + 1 < SIZE) and s[i - R[i] - 1] == s[i + R[i] + 1] :
            R[i] += 1
        if r < i + R[i] :
            r = i + R[i]
            c = i
    return max(R)

if __name__ == "__main__" :
    print(Manacher(input()))
