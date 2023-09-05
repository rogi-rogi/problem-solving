X, K = map(int, input().split())
A = [*map(int, input().split())]
matching = [False] * 10001
half_size = len(A) >> 1
res = 0
for l in range(half_size) :
    if not matching[A[l]] :
        for r in range(half_size, len(A)) :
            if A[l] != A[r] :
                matching[A[l]] += 1
        res += matching[A[l]]
    else : res += matching[A[l]]
print(res)
