N, M = map(int, input().split())
A, B = [], []
for matrix in [A, B]:
    for _ in range(N):
        matrix.append([*map(int, input().split())])
for i in range(N):
    for j in range(M):
        A[i][j] += B[i][j]
    print(*A[i])
