from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, K = map(int, input().split())

    # Solve
    coins = sorted([int(input()) for _ in range(N)], reverse=True)
    cnt = 0
    for coin in coins:
        if K >= coin:
            cnt += K // coin
            K %= coin

    # Output
    print(cnt)
