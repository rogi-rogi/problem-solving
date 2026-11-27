if __name__ == '__main__':
    answer = []
    while True:
        n = int(input())
        if n == -1:
            break
        
        divisors = [1]
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                divisors.append(i)
                pair = n // i
                if pair != i:
                    divisors.append(pair)
                    
        if sum(divisors) == n:
            divisors.sort()
            exp = " + ".join(map(str, divisors))
            answer.append(f"{n} = {exp}")
        else:
            answer.append(f"{n} is NOT perfect.")
    
    print(*answer, sep='\n')
