from sys import stdin
MAX = 1000001
N = int(stdin.readline())
F = 0
for i in range(1, N + 1) :
    for j in range(i, N + 1, i) :
        F += i
print(F)
