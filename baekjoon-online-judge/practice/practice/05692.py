from sys import stdin
from math import factorial
input=stdin.readline

if __name__ == '__main__':
    while True:
        N = input().rstrip()
        if N == '0':
            break
        SIZE = len(N)
        res = 0
        for i in range(len(N)):
            res += int(N[i]) * factorial(SIZE - i)
        print(res)
