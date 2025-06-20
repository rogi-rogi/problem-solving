'''
https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-select-segments-without-overlap-2/description
'''

n = int(input())
x = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.

dp = [1] * n
x.sort()

for start in range(n):
    for end in range(start):
        if x[end][1] < x[start][0]:
            dp[start] = max(dp[start], dp[end] + 1)

print(max(dp))