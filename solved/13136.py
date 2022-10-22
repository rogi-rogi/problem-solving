R, C, N = map(int, input().split())
print((R // N + ([1, 0][R % N == 0])) * (C // N + ([1, 0][C % N == 0])))
