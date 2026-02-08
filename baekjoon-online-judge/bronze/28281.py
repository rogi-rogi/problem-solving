N, X = map(int, input().split())
res = 2000
A = [*map(int, input().split())]
for i in range(N - 1) :
    res = min(res, A[i] + A[i - 1])
print(res * X)
