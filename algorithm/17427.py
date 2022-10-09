N = int(input())
F = N
for i in range(2, N // 2 + 1) :
    F += N // i * i
for i in range(N // 2 + 1, N + 1) :
    F += i
print(F)
