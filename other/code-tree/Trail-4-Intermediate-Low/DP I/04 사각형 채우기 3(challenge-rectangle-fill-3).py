'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rectangle-fill-3/description
'''

n = int(input())

# Please write your code here.

def solve(N):
    if N == 1:
        return 2
    if N == 2:
        return 7

    MOD = int(1e9) + 7
    dp = [0] * (N + 1)
    sum_dp = [0] * (N + 1)
    dp[1] = 2
    dp[2] = 7
    sum_dp[0] = 1
    sum_dp[1] = sum_dp[0] + dp[1]
    sum_dp[2] = sum_dp[1] + dp[2]
    for i in range(3, N + 1):
        dp[i] = (2*dp[i - 1] + 3*dp[i - 2] + 2*sum_dp[i - 3]) % MOD
        sum_dp[i] = (sum_dp[i - 1] + dp[i]) % MOD
    return dp[N]

print(solve(n))