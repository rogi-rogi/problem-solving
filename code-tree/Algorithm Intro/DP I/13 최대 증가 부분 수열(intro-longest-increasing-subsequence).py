'''
https://www.codetree.ai/ko/trails/complete/curated-cards/intro-longest-increasing-subsequence/description
'''

n = int(input())
m = list(map(int, input().split()))

# Please write your code here.

dp = [1] * n

for i in range(1, n):
    for j in range(i):
        if m[j] < m[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))