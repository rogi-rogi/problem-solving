from sys import stdin
input = stdin.readline

stack = [int(input()) for _ in range(int(input()))]
long_stick = stack[-1]
cnt = 1
for s in stack[::-1] :
    if s > long_stick :
        long_stick = s
        cnt += 1
print(cnt)
