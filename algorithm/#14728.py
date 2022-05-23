from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N, T = map(int, input().split())
    dp = {0 : 0}
    for _ in range(N) :
        K, S = map(int, input().split())
        temp = dict()
        for s, k in dp.items() :
            ns, nk = S + s, K + k
            if nk < dp.get(ns, T + 1) :
                temp[ns] = nk
        dp.update(temp)
    print(max(dp.keys()))
