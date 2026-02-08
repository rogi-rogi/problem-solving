N = int(input())
A = list(map(int, input().split()))
B, C = map(int, input().split())
cnt = N
for i in range(N) :
    A[i] -= B
    if A[i] <= 0 : continue
    cnt += A[i] // C + (1 if A[i] % C else 0)
print(cnt)
