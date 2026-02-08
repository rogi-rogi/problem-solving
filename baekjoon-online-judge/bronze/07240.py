from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N, S = map(int, input().split())

    # Solve
    res = 0
    for _ in range(N):
        a = int(input())
        if res > S: a -= 1
        res += a

    # Output
    print(res)
