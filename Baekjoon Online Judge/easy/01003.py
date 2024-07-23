from sys import stdin
input = stdin.readline

SIZE = 41

if __name__ == '__main__':
    # Solve
    dp = [[0] * 2 for _ in range(SIZE)]
    dp[0] = [1, 0]
    dp[1] = [0, 1]
    for i in range(2, SIZE):
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0]
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1]

    # Input
    for _ in range(int(input())):
        N = int(input())

        # Output
        print(dp[N][0], dp[N][1])
