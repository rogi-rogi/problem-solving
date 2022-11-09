def Manacher(s) :
    s = '#' + '#'.join(s) + '#'
    SIZE = len(s)
    r = 0 # 'r' is last index of sub-palindrome
    c = 0 # 'c' is center index of sub-palindrome
    R = [0] * SIZE # 'R[i]' is radius of sub-palindrome centered on 's[i]'
    for i in range(SIZE) :
        # if r < i : R[i] = 0 # away from parent palindrome
        if i <= r : R[i] = min(r - i, R[c + c - i])
        # min(palindrome on the other side, guaranteed that 's[i]'' is palindrome until leaves parent palindrome)
        
        while (0 <= i - R[i] - 1 and i + R[i] + 1 < SIZE) and s[i - R[i] - 1] == s[i + R[i] + 1] :
            R[i] += 1
        if r < i + R[i] :
            r = i + R[i]
            c = i
    return max(R)

if __name__ == "__main__" :
    print(Manacher(input()))
