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
    return R
    
if __name__ == "__main__" :
    input()
    R = Manacher(''.join([*input().split()]))
    for _ in range(int(input())) :
        S, E = map(int, input().split())
        S, E = min(S, E), max(S, E)
        mid = ((S * 2 - 1) + (E * 2 - 1)) // 2
        print([0, 1][R[mid] >= E - S + 1])
