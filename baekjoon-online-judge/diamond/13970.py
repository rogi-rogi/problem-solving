from sys import stdin
input = stdin.readline

def make_phi(n):
    phi = list(range(n + 1))
    if n >= 1:
        phi[1] = 1

    for i in range(2, n + 1):
        if phi[i] == i:
            for j in range(i, n + 1, i):
                phi[j] -= phi[j] // i
    return phi

def tower_ge(X, pos, limit):
    n = len(X)

    if limit <= 1:
        return True

    while True:
        if pos == n - 1:
            return X[pos] >= limit

        a = X[pos]

        if a == 1:
            return 1 >= limit

        need = 0
        value = 1

        while value < limit:
            value *= a
            need += 1

        pos += 1
        limit = need

        if limit <= 1:
            return True

def solve(X, M, phi):
    n = len(X)

    if M == 1:
        return 0

    mods = [M]
    for _ in range(n):
        mods.append(phi[mods[-1]])

    val = X[-1] % mods[n - 1]
    big = X[-1] >= mods[n - 1]

    for i in range(n - 2, -1, -1):
        mod = mods[i]
        phi_mod = mods[i + 1]

        if mod == 1:
            val = 0
            big = True
            continue

        exp = val
        if big:
            exp += phi_mod

        val = pow(X[i], exp, mod)
        big = tower_ge(X, i, mod)

    return val

T, M = map(int, input().split())
phi = make_phi(M)

for _ in range(T):
    arr = list(map(int, input().split()))
    N = arr[0]
    X = arr[1:]
    print(solve(X, M, phi))