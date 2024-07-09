from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    N, K = map(int, input().split())
    digit = []
    POW_K = K ** 2
    while N > 0:
        N, mod = divmod(N, POW_K)
        digit.append(mod)

    res = 0
    flag = True
    for i in range(len(digit) - 1, -1, -1):
        if digit[i] < K:
            res += digit[i]
            res *= K
        else:
            res += K
            res *= K ** i
            break
    else:
        res //= K
        res += 1
    print(res)
