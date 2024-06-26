from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    N = int(input())
    M = int(input())
    res = M
    for _ in range(N):
        _in, _out = [*map(int, input().split())]
        _in -= _out
        if M + _in < 0:
            res = 0
            break
        else:
            M += _in
            res = max(res, M)
    print(res)
