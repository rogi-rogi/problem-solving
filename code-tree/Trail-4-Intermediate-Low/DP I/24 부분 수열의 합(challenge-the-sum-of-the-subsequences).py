'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-sum-of-the-subsequences/description
'''

n, m = map(int, input().split())
A = list(map(int, input().split()))

# Please write your code here.

dp = [False] * (m + 1)
dp[0] = True

for a in A:
    for i in range(m, a - 1, -1):
        if dp[i - a]:
            dp[i] = True

print(['No', 'Yes'][dp[m]])