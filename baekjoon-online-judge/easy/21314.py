from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    S = input().rstrip()
    MAX = []
    MIN = []

    # Solve
    prev = 0
    for cur in range(len(S)):
        if S[cur] == 'K':
            MAX.append('5' + '0'*(cur-prev))
            prev = cur + 1
    if prev != len(S):
        MAX.append('1'*(len(S)-prev))
    prev = 0
    for cur in range(len(S)):
        if S[cur] == 'M' and cur + 1 < len(S) and S[cur + 1] == 'K':
            MIN.append('1' + '0'*(cur - prev))
            prev = cur + 1
        if S[cur] == 'K':
            MIN.append('5')
            prev = cur + 1
    if prev != len(S):
        MIN.append('1' + '0'*(len(S)-prev-1))

    # Output
    print(*MAX, sep='')
    print(*MIN, sep='')