from collections import deque
from copy import deepcopy
from itertools import combinations
from sys import stdin
input = stdin.readline
                
def spreadVirus() :
    board = deepcopy(graph)
    queue = deque(virus)
    while queue :
        x, y = queue.popleft()
        for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)] :
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 :
                board[nx][ny] = 2
                queue.append((nx, ny))
    return sum(i.count(0) for i in board)           # count clean area

def buildWall() :
    res = 0
    empty_area = [(i, j) for i in range(N) for j in range(M) if graph[i][j] == 0]
    for build_wall in combinations(empty_area, 3) :
        for x, y in build_wall : graph[x][y] = 1    # build wall
        res = max(res, spreadVirus())
        for x, y in build_wall : graph[x][y] = 0    # unbuild wall
    return res
                
if __name__ == "__main__" :
    N, M = map(int, input().split())
    graph = [[*map(int, input().split())] for _ in range(N)]
    virus = [(i, j) for i in range(N) for j in range(M) if graph[i][j] == 2]
    print(buildWall())
