from sys import stdin
input = stdin.readline

'''
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
'''

def Manacher(S) :
    s = ['#'] * (len(S) * 2 + 1)
    s[1::2] = S
    SIZE = len(s)
    R = [0] * SIZE
    r, c = 0, 0
    for i in range(SIZE - 1) :
        if i <= r : R[i] = min(r - i, R[c + c - i])
        while (0 <= i - R[i] - 1 and i + R[i] + 1 < SIZE) and s[i - R[i] - 1] == s[i + R[i] + 1] :
            R[i] += 1
        if r < i + R[i] :
            r = i + R[i]
            c = i
    return R

if __name__ == "__main__" :
    input()
    S = input().split()
    Manacher(S)
    for _ in range(int(input())) :
        S, E = map(int, input().split())
        print(0 + (R[S + E - 1] >= E - S + 1))
