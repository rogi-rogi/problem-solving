from math import inf
from sys import stdin
input = stdin.readline

def BellmanFord(v) :
    dist = [inf] * (V + 1)
    dist[v] = 0
    for i in range(V) :
        for v1, v2, w in edges :
            if dist[v1] != inf and dist[v1] + w < dist[v2] :
                if i == V - 1 : return False
                dist[v2] = dist[v1] + w
    return dist

if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = [[*map(int, input().split())] for _ in range(E)]
    dist = BellmanFord(1)
    if not dist : print(-1)
    else : print(*[-1 if dist[i] == inf else dist[i] for i in range(2, V + 1)], sep = '\n')
