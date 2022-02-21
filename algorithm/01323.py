from sys import stdin

if __name__ == "__main__" :
    N, K = map(int, stdin.readline().split())
    cnt = -2
    next_N, mul = N, pow(10, len(str(N)))
    for i in range(K) :
        next_N %= K
        if next_N == 0  :
            cnt = i
            break
        next_N = next_N * mul + N
    print(cnt + 1)
