def SieveOfEratosthenes(n) :
    primes = [1] * (n + 1)
    primes[0] = primes[1] = 0
    i = 2
    while i * i <= n :
        if primes[i] == 1:
            for j in range(2 * i, n + 1, i) :
                primes[j] = 0
        i += 1
    return primes
    
if __name__ == "__main__" :
    N = int(input())
    primes = SieveOfEratosthenes(N)
    sum_primes = [0]
    temp = 0
    for i in range(2, N + 1) :
        if primes[i] :
            temp += i
            sum_primes.append(temp)
    left = cnt = 0
    right = 1
    while left <= right and right < len(sum_primes) :
        temp = sum_primes[right] - sum_primes[left]
        if temp > N : left += 1
        else :
            if temp == N : cnt += 1
            right += 1
    print(cnt)
    
