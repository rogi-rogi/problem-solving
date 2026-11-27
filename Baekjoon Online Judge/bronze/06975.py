from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        # Input
        n = int(input())

        # Solve
        divisor_sum = 0
        for i in range(1, n // 2 + 1):
            if n % i == 0:
                divisor_sum += i
        res = 'a perfect'
        if divisor_sum < n:
            res = 'a deficient'
        elif divisor_sum > n:
            res = 'an abundant'

        # Output
        print(f'{n} is {res} number.')
