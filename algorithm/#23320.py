N = int(input())
A = list(map(int, input().split()))
X, Y = map(int, input().split())
cnt = 0
for i in A :
    if i >= Y : cnt += 1
print(N * X // 100, cnt)
