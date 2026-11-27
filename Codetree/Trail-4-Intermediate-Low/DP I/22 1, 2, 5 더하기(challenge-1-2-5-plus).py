'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-1-2-5-plus/description
'''

n = int(input())

# Please write your code here.

MOD = int(1e4 + 7)

dp = [0] * (n + 1)
nums = [1, 2, 5]

dp[0] = 1

for i in range(1, n + 1):
    for num in nums:
        if i >= num:
            dp[i] = (dp[i] + dp[i - num]) % MOD

print(dp[n])