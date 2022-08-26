from collections import deque
from sys import stdin
input = stdin.readline

def spreadVirus() :
    cnt = 0
    while queue :
        x, y = queue.popleft()
        for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)] :
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] == 0 :
                temp[nx][ny] = temp[x][y] + 1
                
def chooseVirus(idx, cnt) :
    if cnt == M :
        queue = deque()
        pass
    else :
        for i in range(idx, cnt_virus) :
            if not select_virus[i] :
                select_virus[i] = True
                chooseVirus(idx + 1, cnt + 1)
                select_virus[i] = False
                
if __name__ == "__main__" :
    N, M = map(int, input().split())
    graph, virus = [], []
    for i in range(N) :
        graph.append([*map(int, input().split())])
        for j in range(N) :
            if graph[i][j] == 2 :
                virus.append([i, j])
                graph[i][j] = 0
    cnt_virus = len(virus)
    select_virus = [False] * 10
    sec = N ** 2
    chooseVirus(0, 0)
    print([sec, -1][sec == N ** 2])
    
