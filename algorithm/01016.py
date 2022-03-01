def SquareFreeInteger(start, n = 0) :
    if n == 0 : start, n = n, start
    isSFI = [1] * (n - start + 1)
    i = 2
    while i * i <= n :
        pow_prime = i * i
        first_not_SFI = start // pow_prime * pow_prime
        for j in range(first_not_SFI, n + 1, pow_prime) :
            if j - start >= 0 :
                isSFI[j - start] = 0
        i += 1
    return isSFI
    
if __name__ == "__main__" :
    MIN, MAX = map(int, input().split())
    print(sum(SquareFreeInteger(MIN, MAX)))
