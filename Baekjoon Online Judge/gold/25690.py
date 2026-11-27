from sys import stdin, setrecursionlimit
setrecursionlimit(int(1e5 + 4))
input = stdin.readline

WHITE = 0
BLACK = 1

def dfs(i):
    visited[i] = True
    dp[WHITE][i] = price[i][WHITE]
    dp[BLACK][i] = price[i][BLACK]
    for v in graph[i]:
        if not visited[v]:
            dfs(v)
            dp[WHITE][i] += min(dp[WHITE][v], dp[BLACK][v])
            dp[BLACK][i] += dp[WHITE][v]

if __name__ == '__main__':
    # Input
    N = int(input())

    graph = [[] for _ in range(N)]
    visited = [False] * (N)
    for _ in range(N - 1):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    price = [[*map(int, input().split())] for _ in range(N)]

    # Solve
    dp = [[0] * (N) for _ in range(2)]
    dfs(1)

    # Output
    print(min(dp[WHITE][1], dp[BLACK][1]))