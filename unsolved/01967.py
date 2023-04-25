from collections import deque
from sys import stdin
input = stdin.readline

def BFS(start, flag = 0) :
    visited = [-1] * (V + 1)
    queue = deque([start])
    visited[start] = 0
    while queue :
        v1 = queue.popleft()
        for v2, w in edges[v1] :
            if visited[v2] == -1 :
                visited[v2] = visited[v1] + w
                queue.append(v2)
    if flag == 0 :
        idx, dist = 0, 0
        for i in range(1, V + 1) :
            if dist < visited[i] :
                dist = visited[i]
                idx = i
        return idx
    else : return max(visited)

if __name__ == "__main__" :
    V = int(input())
    edges = [[] for _ in range(V + 1)]
    for _ in range(V - 1) :
        v1, v2, w = map(int, input().split())
        edges[v1].append((v2, w))
        edges[v2].append((v1, w))
    print(BFS(BFS(1), 1))
    
