def exEuclid(a, b) : 
    def onTimeGCD(a, b, q) : return (b, a - q * b)
    d0, d1 = a, b
    s0, s1 = 1, 0
    while d1 :
        q = d0 // d1
        d0, d1 = onTimeGCD(d0, d1, q)
        s0, s1 = onTimeGCD(s0, s1, q)
    return (s0 + [0, b][s0 <= 0]) if d0 == 1 else -1
    
if __name__ == "__main__" :
    N, A = map(int, input().split())
    C = exEuclid(A, N)
    print(N - A, C)
