from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    nA, nB = map(int, input().split())
    A = set(map(int, input().split()))
    B = set(map(int, input().split()))
    res = A - B
    if res :
        print(len(res))
        print(*sorted([*res]))
    else:
        print(0)
