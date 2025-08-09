'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-knapsack/description
'''

N, M = map(int, input().split())
w, v = zip(*[tuple(map(int, input().split())) for _ in range(N)])
w, v = list(w), list(v)

# Please write your code here.

dp = [0] * (M + 1)

for i in range(N):
    for m in range(M, w[i] - 1, -1):
        dp[m] = max(dp[m], dp[m - w[i]] + v[i])

print(dp[M])