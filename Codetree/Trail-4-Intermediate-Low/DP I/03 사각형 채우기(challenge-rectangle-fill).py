'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rectangle-fill/description
'''

n = int(input())

# Please write your code here.

def solve(N):
    if N <= 2:
        return N

    MOD = int(1e4) + 7
    dp = [0] * (N + 1)
    dp[1] = 1
    dp[2] = 2
    for i in range(3, N + 1):
        dp[i] = (dp[i - 1] + dp[i - 2]) % MOD

    return dp[N]

print(solve(n))