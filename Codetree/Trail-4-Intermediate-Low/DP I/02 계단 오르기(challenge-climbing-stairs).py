'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-climbing-stairs/description
'''

n = int(input())

# Please write your code here.

def solve(N):
    if N <= 3:
        return 1

    MOD = int(1e4) + 7
    dp = [0] * (N + 1)
    dp[2] = 1
    dp[3] = 1
    for i in range(4, N + 1):
        dp[i] = (dp[i - 2] + dp[i - 3]) % MOD

    return dp[N]

print(solve(n))