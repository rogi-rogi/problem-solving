from collections import deque
from sys import stdin

input = stdin.readline

def dfs(start):
    visited[start] = True
    res_dfs.append(start)
    for v in graph[start]:
        if not visited[v]:
            dfs(v)

def bfs(start):
    visited[start] = True
    res_bfs.append(start)
    queue = deque([start])
    while queue:
        cur = queue.popleft()
        for v in graph[cur]:
            if not visited[v]:
                visited[v] = True
                res_bfs.append(v)
                queue.append(v)


if __name__ == '__main__':
    # Input
    N, M, V = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    for i in range(1, N + 1):
        graph[i].sort()

    res_dfs = []
    visited = [False] * (N + 1)
    dfs(V)
    res_bfs = []
    visited = [False] * (N + 1)
    bfs(V)

    print(*res_dfs)
    print(*res_bfs)