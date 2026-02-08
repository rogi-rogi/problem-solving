from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    S = ' ' + input().rstrip()
    N = len(S) - 1
    
    # Solve
    dp = [0] * 31
    prefix_sum_dp = [0] * 31
    for l in range(1, N + 1):
        for r in range(l, N + 1):
            if S[l] == S[r]:
                dp[r] += prefix_sum_dp[N] - prefix_sum_dp[r] + 1
            prefix_sum_dp[r] = prefix_sum_dp[r - 1] + dp[r]

    # Output
    print(prefix_sum_dp[N])

'''
from sys import stdin
input = stdin.readline

def dfs(L, R):
    if L == R: return 1
    if dp[L][R] != -1:
        return dp[L][R]
    cnt = 0
    for l in range(L, R + 1):
        for r in range(l, R + 1):
            if S[l] == S[r]:
                if r - l <= 1: cnt += 1
                else:
                    cnt += 1 + dfs(l + 1, r - 1)
    dp[L][R] = cnt
    return dp[L][R]

if __name__ == '__main__':
    # Input
    S = input().rstrip()
    N = len(S)

    # Solve
    dp = [[-1] * 30 for _ in range(30)]
    res = dfs(0, N - 1)

    # Output
    print(res)
'''
