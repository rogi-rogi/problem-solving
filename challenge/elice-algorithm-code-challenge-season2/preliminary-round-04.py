from collections import defaultdict
NO_CHILD = int(1e10)

def dfs(cur, parent):
    diff = NO_CHILD
    
    for child in edge[cur]:
        if child == parent:
            continue
        dfs(child, cur)
        diff = min(diff, dp[child])

    dp[cur] = cur - (0 if diff == NO_CHILD else diff)


if __name__ == '__main__':
    N = int(input())
    dp = [None] * (N + 1) 
    edge = defaultdict(list)
    for _ in range(N - 1):
        u, v = map(int, input().split())
        edge[u].append(v)
        edge[v].append(u)
    dfs(1, 0)
    res = [1 if dp[i] >= 0 else 0 for i in range(1, N + 1)]
    print(*res, sep='\n')
