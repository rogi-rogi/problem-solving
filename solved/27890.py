X0, N = map(int, input().split())
Xt = X0
for _ in range(N) :
    if Xt % 2 : Xt = ((2 * Xt) ^ 6)
    else : Xt = (Xt // 2) ^ 6
print(Xt)
