from collections import deque
from copy import deepcopy
from sys import stdin
input = stdin.readline
                
def spreadVirus() :
    board = deepcopy(graph)
    queue = deque()
    for x, y in virus :
        queue.append((x, y))
        while queue :
            x, y = queue.popleft()
            for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)] :
                nx, ny = x + dx, y + dy
                if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 :
                    board[nx][ny] = 2
                    queue.append((nx, ny))
    return sum(i.count(0) for i in board) # count clean area

def buildWall(n, m, cnt) :
    if cnt == 3 : return spreadVirus()
    res = 0
    for i in range(n, N) :
        for j in range(m if i == n else 0, M) :
            if graph[i][j] == 0 :
                graph[i][j] = 1
                res = max(res, buildWall(i, j, cnt + 1))
                graph[i][j] = 0
    return res
                
if __name__ == "__main__" :
    N, M = map(int, input().split())
    graph = [[*map(int, input().split())] for _ in range(N)]
    virus = [(i, j) for i in range(N) for j in range(M) if graph[i][j] == 2]
    print(buildWall(0, 0, 0))
