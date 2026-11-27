'''
https://www.codetree.ai/ko/trails/complete/curated-cards/intro-coin-change/description
'''

N, M = map(int, input().split())
coin = list(map(int, input().split()))

# Please write your code here.

INF = int(1e10)
dp = [INF] * (M + 1)
dp[0] = 0
for i in range(1, M + 1):
    for c in coin:
        if i >= c:
            dp[i] = min(dp[i], dp[i - c] + 1)

print([dp[M], -1][dp[M] == INF])