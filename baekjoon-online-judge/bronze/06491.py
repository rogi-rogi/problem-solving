from sys import stdin
input = stdin.read

if __name__ == '__main__':
    # Input
    nums = [*map(int, input().split())][:-1]

    # Solve
    for num in nums:
        div_num_sum = sum([i for i in range(1, num) if num % i == 0])
        res = 'DEFICIENT'
        if div_num_sum == num: res = 'PERFECT'
        elif div_num_sum > num: res = 'ABUNDANT'

        # Output
        print(f'{num} {res}')
