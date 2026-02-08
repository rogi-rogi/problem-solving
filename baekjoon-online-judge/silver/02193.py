from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    dp = [0] * (N + 1)
    dp[1] = 1

    # Solve
    for i in range(2, N + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    # Output
    print(dp[N])
    
