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
    for _ in range(V) :
        v1, *info = map(int, input().split())
        for v2 in range(0, len(info) - 2, 2) :
            edges[v1].append((info[v2], info[v2 + 1]))
    print(BFS(BFS(1), 1))
