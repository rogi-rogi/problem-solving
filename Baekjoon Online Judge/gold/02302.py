from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    M = int(input())
    vip = [False] * (N + 1)
    for _ in range(M):
        vip[int(input())] = True

    # Solve
    dp = [1] * (N + 1)
    res = 1
    for i in range(2, N + 1):
        if not vip[i]:
            if not vip[i - 1]:
                dp[i] = dp[i - 1] + dp[i - 2]
        else:
            res *= dp[i - 1]
    res *= dp[N]

    # Output
    print(res)
