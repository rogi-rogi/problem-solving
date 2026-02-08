from sys import stdin
input = stdin.readline

N, M, Q = map(int, input().split())
SIZE = 500001
R = [0] * SIZE
C = [0] * SIZE
for _ in range(Q) :
    t, line, v = map(int, input().split())
    if t == 1 :
        R[line] += v
    else :
        C[line] += v

bfr = []
for i in range(1, N + 1) :
    for j in range(1, M + 1) :
        print(R[i] + C[j], end=' ')
    print()
