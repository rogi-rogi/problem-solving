from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        N = int(input())
        coins = [0, *map(int, input().split())]
        M = int(input())

        # Solve
        dp = [0] * (M+1)
        dp[0] = 1
        for coin in coins:
            for m in range(coin, M + 1):
                dp[m] += dp[m - coin]

        # Output
        print(dp[M])
