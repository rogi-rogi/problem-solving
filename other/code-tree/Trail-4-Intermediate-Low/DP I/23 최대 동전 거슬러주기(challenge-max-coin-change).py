'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-max-coin-change/description
'''

N, M = map(int, input().split())
coin = list(map(int, input().split()))

# Please write your code here.

dp = [-1] * (M + 1)
dp[0] = 0
for i in range(1, M + 1):
    for num in coin:
        if i >= num and dp[i - num] != -1:
            dp[i] = max(dp[i], dp[i - num] + 1)

print([dp[M], -1][dp[M] == 0])