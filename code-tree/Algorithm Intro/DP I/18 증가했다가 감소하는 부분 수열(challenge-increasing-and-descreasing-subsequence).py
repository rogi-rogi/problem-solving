'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-increasing-and-descreasing-subsequence/description
'''

n = int(input())
sequence = list(map(int, input().split()))

# Please write your code here.

dp = [[1] * n for _ in range(2)]

for i in range(n):
    for j in range(i):
        if sequence[j] < sequence[i]:
            dp[0][i] = max(dp[0][i], dp[0][j] + 1)
        if sequence[j] > sequence[i]:
            dp[1][i] = max(dp[1][i], dp[1][j] + 1)
    dp[1][i] = max(dp[0][i], dp[1][i])

res = 0
for i in range(n):
    res = max(res, dp[1][i])

print(res)