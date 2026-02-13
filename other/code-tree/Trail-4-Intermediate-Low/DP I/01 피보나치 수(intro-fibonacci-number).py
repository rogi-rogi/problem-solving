'''
https://www.codetree.ai/ko/trails/complete/curated-cards/intro-fibonacci-number/description
'''

N = int(input())

# Please write your code here.

def fibo(N):
    if N == 1 or N == 2:
        return 1

    dp = [0] * (N + 1)
    dp[1] = 1
    dp[2] = 1
    for i in range(3, N + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    return dp[N]

print(fibo(N))