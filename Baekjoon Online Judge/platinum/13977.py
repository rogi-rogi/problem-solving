from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    MAX = 4000001
    MOD = int(1e9) + 7
    fac = [1] * MAX
    for i in range(1, MAX) : fac[i] = fac[i - 1] * i % MOD
    facinv = [1] * MAX
    facinv[MAX - 1] = pow(fac[MAX - 1], MOD - 2, MOD)
    for i in range(MAX - 2, -1, -1) : facinv[i] = (i + 1) * facinv[i + 1] % MOD
    for _ in range(int(input())) :
        N, K = map(int, input().split())
        print(((fac[N] * facinv[K]) % MOD) * facinv[N - K] % MOD)
