'''
https://www.codetree.ai/ko/trails/complete/curated-cards/test-being-rich-by-working-part-time/description
'''

n = int(input())
jobs = [tuple(map(int, input().split())) for _ in range(n)]

jobs.sort(lambda x : x[1])
s = [job[0] for job in jobs]
e = [job[1] for job in jobs]
p = [job[2] for job in jobs]

# Please write your code here.

dp = [0] * n
dp[0] = p[0]
for i in range(n):
    dp[i] = p[i]
    for j in range(i):
        if e[j] < s[i]:
            dp[i] = max(dp[i], dp[j] + p[i])

print(max(dp))