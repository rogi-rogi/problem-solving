'''
https://www.codetree.ai/ko/trails/complete/curated-cards/intro-the-sum-of-the-subsequences-is-m/description
'''

n, m = map(int, input().split())
A = list(map(int, input().split()))

# Please write your code here.

INF = int(1e10)
dp = [INF] * (m + 1)
dp[0] = 0
for a in A:
    for i in range(m, a - 1, -1):
        if dp[i - a] != INF:
            dp[i] = min(dp[i], dp[i - a] + 1)

print([dp[m], -1][dp[m] == INF])