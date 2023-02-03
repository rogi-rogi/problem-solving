from collections import deque
from math import inf
from sys import stdin
input = stdin.readline

def BFS01(vx, vy, MX, MY) :
    dist = [[-1] * MY for _ in range(MX)]
    dist[vx][vy] = 0
    dq = deque([(vx, vy)])
    while dq :
        x, y = dq.popleft()
        for nx, ny in [(x+1, y), (x-1, y), (x, y+1), (x, y-1)] :
            if 0 <= nx < MX and 0 <= ny < MY :
                if dist[nx][ny] == -1 :
                    if not graph[nx][ny] :
                        dist[nx][ny] = dist[x][y]
                        dq.appendleft((nx, ny))
                    else :
                        dist[nx][ny] = dist[x][y] + 1
                        dq.append((nx, ny))
    return dist
    
if __name__ == "__main__" : 
    M, N = map(int, input().split())
    graph = [[*map(int, input().rstrip())] for _ in range(N)]
    dist = BFS01(0, 0, N, M)
    print(dist[N-1][M-1])
