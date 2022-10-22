# Fermat's little theroem ver.
def FermatLittleTheroemModular(a, p) :
    return pow(a, p - 2, p) % p
    
if __name__ == "__main__" :
    m, seed, x1, x2 = map(int, input().split())
    if x1 == x2 : print(0, x1)
    else :
        a = (x1 - x2) * FermatLittleTheroemModular(seed - x1, m) % m
        c = (x1 - a * seed) % m
        print(a, c)
        
# extend Euclid ver.
def exEuclid(a, b) : 
    def onTimeGCD(a, b, q) : return (b, a - q * b)
    d0, d1 = a, b
    t0, t1 = 0, 1
    while d1 :
        q = d0 // d1
        d0, d1 = onTimeGCD(d0, d1, q)
        t0, t1 = onTimeGCD(t0, t1, q)
    return (t0 + [0, a][t0 <= 0]) if d0 == 1 else -1
    
if __name__ == "__main__" :
    m, seed, x1, x2 = map(int, input().split())
    if x1 == x2 : print(0, x1)
    else :
        temp = exEuclid(m, (x1 - x2 + m) % m)
        a = exEuclid(m, ((seed - x1) * temp + m) % m)
        c = (-a * seed + x1 + m) %m
        print(a, c)
