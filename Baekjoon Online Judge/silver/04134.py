from sys import stdin

input = stdin.readline


def next_prime(n):
    if n <= 2:
        return 2
        
    if n % 2 == 0:
        n += 1
        
    while True:
        for divisor in range(3, int(pow(n, 0.5)) + 1, 2):
            if n % divisor == 0:
                break
        else:
            return n
        n += 2
        
        
if __name__ == '__main__':
    answer = [next_prime(int(input())) for _ in range(int(input()))]
    
    print(*answer, sep='\n')
