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
        for i in range(1, N + 1):
            for m in range(1, M + 1):
                if m >= coins[i]:
                    dp[m] += dp[m - coins[i]]
                    
        # Output
        print(dp[M])
