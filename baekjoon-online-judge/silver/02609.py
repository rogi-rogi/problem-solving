from sys import stdin

input = stdin.readline

def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)

def lcm(a, b):
    return int(a * b / gcd(a, b))

if __name__ == '__main__':
    res = []

    # Input
    A, B = map(int, input().split())
    GCD = gcd(A, B)

    # Output
    print(GCD, int(A * B / GCD), sep='\n')