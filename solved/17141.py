from collections import deque
from itertools import combinations
from sys import stdin
input = stdin.readline

def spreadVirus(queue, visited) :
    spread_cnt = 0
    while queue :
        x, y = queue.popleft()
        for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)] :
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and graph[nx][ny] == 0 :
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))
                spread_cnt += 1
    return spread_cnt, max(max(visited[i]) for i in range(N))   # is max_sec
    
def chooseVirus() :
    empty_cnt = N ** 2 - M - wall_cnt
    res = N ** 2
    for select_virus in combinations(virus, M) :
        visited = [[0] * N for _ in range(N)]
        queue = deque(select_virus)
        for x, y in select_virus : graph[x][y] = 2      # mark virus
        cnt_spread, max_sec = spreadVirus(queue, visited)
        if empty_cnt - cnt_spread == 0 : res = min(res, max_sec)
        for x, y in select_virus : graph[x][y] = 0      # unvirus virus
    return [res, -1][res == N ** 2]
    
if __name__ == "__main__" :
    N, M = map(int, input().split())
    graph, virus = [], []
    wall_cnt = 0
    for i in range(N) :
        graph.append([*map(int, input().split())])
        for j in range(N) :
            if graph[i][j] == 2 :
                virus.append([i, j])
                graph[i][j] = 0
            elif graph[i][j] == 1 :
                graph[i][j] = -1;           # mark wall
                wall_cnt += 1
    print(chooseVirus())
