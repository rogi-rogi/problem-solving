R, C, N = map(int, input().split())
print((R // N + ([0, 1][R % N != 0])) * (C // N + ([0, 1][C % N != 0])))
