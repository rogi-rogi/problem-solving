from collections import deque
from sys import stdin
input = stdin.readline

def getUnitedInfo(x, y) :
    queue = deque([(x, y)])
    united_nations = [(x, y)]                   # maybe (x, y) is united nations
    sum_population = graph[x][y]
    while queue :
        x, y = queue.popleft()
        for nx, ny in [(x, y + 1), (x + 1, y), (x, y - 1), (x - 1, y)] :
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] :
                if L <= abs(graph[nx][ny] - graph[x][y]) <= R :
                    visited[nx][ny] = True
                    united_nations.append((nx, ny))
                    sum_population += graph[nx][ny]
                    queue.append((nx, ny))
    return united_nations, sum_population
                    
if __name__ == "__main__" :
    N, L, R = map(int, input().split())
    graph = [[*map(int, input().split())] for _ in range(N)]
    day = 0
    while True :
        flag = False
        visited = [[False] * N for _ in range(N)]
        for i in range(N) :
            for j in range(N) :
                if not visited[i][j] :
                    visited[i][j] = True
                    nations, population = getUnitedInfo(i, j)
                    cnt_nations = len(nations)
                    if cnt_nations > 1 :       # maybe united nation and real unsited nations ?
                        flag = True
                        population //= cnt_nations
                        for x, y in nations :
                            graph[x][y] = population
        if not flag : break
        day += 1
    print(day)
