from math import gcd

def exEuclid(a, b) : 
    def onTimeGCD(a, b, q) : return (b, a - q * b)
    d0, d1 = a, b
    t0, t1 = 1, 0
    while d1 :
        q = d0 // d1
        d0, d1 = onTimeGCD(d0, d1, q)
        t0, t1 = onTimeGCD(t0, t1, q)
    return (t0 + [0, b][t0 <= 0]) if d0 == 1 else -1
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        K, C = map(int, input().split())
        MAX = int(1e9)
        impossible = False
        if gcd(K, C) != 1 :
            impossible = True
        else :
            if C == 1 :
                if K + 1 > MAX :
                    impossible = True
                else :
                    print(K + 1)
                    continue
            else :
                X = exEuclid(C, K)
                if X > MAX : impossible = True
        print("IMPOSSIBLE" if impossible else X)
