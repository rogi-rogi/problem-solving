if __name__ == "__main__" :
    MOD = int(1e9) + 7
    N, R = map(int, input().split())
    fac_A = 1               # N! - (N - R)!
    for i in range(N, N - R, -1) :
        fac_A = fac_A * i % MOD;
    fac_B = 1               # R!
    for i in range(2, R + 1) :
        fac_B = fac_B * i % MOD;
    print(fac_A * pow(fac_B, MOD - 2, MOD) % MOD)
