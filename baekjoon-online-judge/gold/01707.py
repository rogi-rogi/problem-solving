from collections import deque
from sys import stdin
input = stdin.readline

G1 = 1
G2 = 2

def bfs(v) :
    color = G1
    visited[v] = color
    queue = deque([v])
    while queue :
        v = queue.popleft()
        color = [G1, G2][visited[v] == G1]
        for nv in graph[v] :
            if not visited[nv] :
                visited[nv] = color
                queue.append(nv)

def is_bipartite_graph() :
    for v in range(1, V + 1) :
        for nv in graph[v] :
            if visited[v] == visited[nv] :
                return False
    return True
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        V, E = map(int, input().split())
        graph = [[] for _ in range(V + 1)]
        visited = [False] * (V + 1)
        for _ in range(E) :
            v1, v2 = map(int, input().split())
            graph[v1].append(v2)
            graph[v2].append(v1)
            
        for i in range(1, V + 1) :
            if not visited[i] :
                bfs(i)
        print(["NO", "YES"][is_bipartite_graph()])
