from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())

    # Solve
    res = 'long long'
    if -2**31 <= N <= 2**31 - 1:
        res = 'int'
    if -2**15 <= N <= 2**15 - 1:
        res = 'short'

    # Output
    print(res)
    
