'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-number-of-unique-bst/description
'''

n = int(input())

# Please write your code here.

def solve(N):
    if N <= 2:
        return [1, 2][N - 1]

    dp = [0] * (N + 1)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    for i in range(3, N + 1):
        for j in range(0, i):
            dp[i] += dp[j] * dp[i - 1 - j]
    return dp[N]

print(solve(n))