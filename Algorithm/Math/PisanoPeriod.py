def PisanoPeriod(N, MOD) : # return Pisano Period table
    if N <= 0 : return [0]
    if N <= 2 : return [0] + [1] * N
    T = [0, 1] + [0] * (N**2 - 1)
    i = 2
    while T[i - 1] != 0 and T[i] != 1 :
        T[i] = (T[i - 1] + T[i - 2]) % MOD
        i += 1
    return T[:i - 1]
