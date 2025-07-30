'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-number-of-jumps/description
'''

n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.

dp = [0] * n
for i in range(n - 2, -1, -1):
    if arr[i] > 0:
        dp[i] = 1
    for j in range(i + 1, min(i + arr[i] + 1, n - 1)):
        dp[i] = max(dp[i], dp[j] + 1)

print(dp[0])