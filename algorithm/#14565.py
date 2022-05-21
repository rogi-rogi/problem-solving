def exGCD(a, b) : 
    def onTimeGCD(a, b, q) : return (b, a - q * b)
    d0, d1 = a, b
    s0, s1 = 1, 0
    t0, t1 = 0, 1
    while d1 :
        q = d0 // d1
        d0, d1 = onTimeGCD(d0, d1, q)
        s0, s1 = onTimeGCD(s0, s1, q)
        t0, t1 = onTimeGCD(t0, t1, q)
    return ((s0, t0), (s0 + b, t0 - a))[s0 <= 0] if d0 == 1 else (-1, -1)
    
if __name__ == "__main__" :
    N, A = map(int, input().split())
    C, K = exGCD(A, N)
    print(N - A, C)
