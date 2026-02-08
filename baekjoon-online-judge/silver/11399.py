from sys import stdin
input = stdin.readline

N = int(input())
P = sorted(list(map(int, input().split())))
result = 0
for i in range(N, 0, -1) :
    result += i * P[N - i]
print(result)
