from math import *
from heapq import heappop, heappush
from itertools import combinations
from collections import defaultdict, deque
from bisect import bisect_left, bisect_right
from sys import stdin, setrecursionlimit
from typing import List, Any

input = stdin.readline
setrecursionlimit(10 ** 6)

INF = int(1e10)


def dfs(cur, _parent):
    depth[cur] = depth[_parent] + 1

    # 희소배열 전처리
    parent[cur][0] = _parent
    for k in range(1, MAX_DEPTH + 1):
        parent[cur][k] = parent[parent[cur][k - 1]][k - 1]
    for child in tree[cur]:
        if child != _parent:
            dfs(child, cur)

def lca(u, v):
    if depth[u] < depth[v]:
        u, v = v, u
    for k in range(MAX_DEPTH, -1, -1):
        if depth[parent[u][k]] >= depth[v]:
            u = parent[u][k]
    if u == v:
        return u
    for k in range(MAX_DEPTH, -1, -1):
        if parent[u][k] != parent[v][k]:
            u = parent[u][k]
            v = parent[v][k]
    return parent[u][0]


if __name__ == '__main__':
    # Init
    tree = defaultdict(list)

    N = int(input())
    # Input
    for _ in range(N - 1):
        u, v = map(int, input().split())
        tree[u].append(v)
        tree[v].append(u)
    MAX_DEPTH = int(log2(N))
    parent = [[0] * (MAX_DEPTH + 1) for _ in range(N + 1)]
    depth = [0] * (N + 1)

    # Solve
    dfs(1, 0)

    res = []
    for _ in range(int(input())):
        u, v = map(int, input().split())
        res.append(lca(u, v))

    # Output
    print(*res, sep='\n')