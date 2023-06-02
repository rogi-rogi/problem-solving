def PisanoPeriod(N, MOD) : # return Pisano Period table
    if N <= 0 : return [0]
    if N <= 2 : return [0] + [1] * N
    T = [0, 1, 1]
    while T[-2] != 0 or T[-1] != 1 :
        T.append((T[-2] + T[-1]) % MOD)
    return T
