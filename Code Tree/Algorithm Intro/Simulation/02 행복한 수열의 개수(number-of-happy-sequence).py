'''
https://www.codetree.ai/missions/2/problems/number-of-happy-sequence?&utm_source=clipboard&utm_medium=text
'''

from sys import stdin
input = stdin.readline

def is_happy_line(line):
    cnt = 1
    for j in range(1, N):
        if line[j] == line[j - 1]:
            cnt += 1
        else:
            cnt = 1
        if cnt >= M:
            break
    return cnt >= M

if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())
    board = [[*map(int, input().split())] for _ in range(N)]
    line = [0] * N
    
    # Solve
    res = 0
    for i in range(N):
        line = board[i][:]
        if is_happy_line(line):
            res += 1
    
    for j in range(N):
        for i in range(N):
            line[i] = board[i][j]
        if is_happy_line(line):
            res += 1

    # Output
    print(res)
