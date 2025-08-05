from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    N = int(input())
    W = sorted([*map(int, input().split())])
    res = 0
    for w in W:
        if res + 1 < w:
            break
        res += w
    print(res + 1)
