N, M = map(int, input().split())
garden = [[-1] * (M + 1) for _ in range(N + 1)]
temp = list(map(int, input().split()))
for i in range(1, N + 1) : garden[i][0] = temp[i - 1]
temp = list(map(int, input().split()))
for i in range(1, M + 1) : garden[0][i] = temp[i - 1]
for i in range(1, N + 1) :
    for j in range(1, M + 1) :
        garden[i][j] = 0 if garden[i-1][j] == garden[i][j-1] else 1
print(garden[N][M])
