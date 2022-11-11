from collections import deque
from math import inf

'''
SPFA (Shortest Path Faster Algorithm)
[ Time Complexity ]
average case : O (E)
worst case   : O (VE)
'''

def SPFA(v) : 
    dist = [inf] * (V + 1)
    dist[v] = 0
    cycle = [0] * (V + 1)
    isEnQueue = [False] * (V + 1)
    isEnQueue[v] = True
    pq = deque([v])
    cnt = 0
    while pq :
        v1 = pq.popleft()
        isEnQueue[v1] = False
        for v2, w in graph[v1].items() :
            if dist[v1] + w < dist[v2] :
                dist[v2] = dist[v1] + w
                if not isEnQueue[v2] :
                    cycle[v2] += 1
                    if cycle[v2] >= V : return False    # find negative cycle.
                    isEnQueue[v2] = True
                    pq.append(v2)
    return dist

if __name__ == "__main__" :
    V, E = map(int, input().split())
    graph = [dict() for _ in range(V + 1)]
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        graph[v1][v2] = min(graph[v1][v2], w) if v2 in graph[v1].keys() else w
    dist = SPFA(1)
    if dist : print(*dist[1:])
    else : print(-1)
