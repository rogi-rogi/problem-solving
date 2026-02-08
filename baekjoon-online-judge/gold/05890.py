from collections import deque
from math import inf
from sys import stdin
input = stdin.readline
MAX = 1001

def BFS01(vx, vy, MX, MY) :
    dist = [[inf] * MY for _ in range(MX)]
    dist[vx][vy] = 0
    dq = deque([(vx, vy)])
    while dq :
        x, y = dq.popleft()
        for nx, ny in [(x+1, y), (x-1, y), (x, y+1), (x, y-1)] :
            if 0 <= nx < MX and 0 <= ny < MY :
                if dist[nx][ny] == inf :
                    if not graph[nx][ny] :
                        dist[nx][ny] = dist[x][y]
                        dq.appendleft((nx, ny))
                    else :
                        dist[nx][ny] = dist[x][y] + 1
                        dq.append((nx, ny))
            else : return dist[x][y] 
            
            '''
            유효성 : 시작점(vx, vy)과 dq로부터 범위내의 영역(x, y)을 받으므로 유효함.
            종료 조건 : 아무 바깥 태두리로 닿는다. 
            '''
            
if __name__ == "__main__" :
    
    N, tx, ty = map(int, input().split())
    graph = [[0]*MAX for _ in range(MAX)]
    for _ in range(N) :
        x, y = map(int, input().split())
        graph[x][y] = 1
    print(BFS01(tx, ty, MAX, MAX))
