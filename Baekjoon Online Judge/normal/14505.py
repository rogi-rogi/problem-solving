from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    S = ' ' + input().rstrip()
    N = len(S) - 1
    
    # Solve
    dp = [0] * 31
    prefix_sum_dp = [0] * 31
    for l in range(1, N + 1):
        for r in range(l, N + 1):
            if S[l] == S[r]:
                dp[r] = dp[r] + prefix_sum_dp[N] - prefix_sum_dp[r] + 1
            prefix_sum_dp[r] = prefix_sum_dp[r - 1] + dp[r]

    # Output
    print(prefix_sum_dp[N])
