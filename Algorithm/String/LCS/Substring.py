'''
LCS (= Longest Common Substring, 최장 공통 부분 문자열)

Time Complexity : O(NM)
N : length first string
M : length second string
'''

def LCS(s1, s2) :   # Longest Common Substring
    s1, s2 = ' ' + s1, ' ' + s2     # preprocessing
    row = len(s1)   # LEFT
    col = len(s2)   # TOP
    length = 0
    dp = [[0] * col for _ in range(row)]
    for r in range(1, row) :
        for c in range(1, col) :
            if s1[r] == s2[c] :
                dp[r][c] = dp[r - 1][c - 1] + 1
                length = max(length, dp[r][c])
    return length

if  __name__ == "__main__" :
    str1 = input()
    str2 = input()
    print(LCS(str1, str2))
