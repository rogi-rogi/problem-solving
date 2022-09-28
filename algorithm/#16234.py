from collections import deque
from sys import stdin
input = stdin.readline
'''
# This code is too slow. Isn't there a faster way...?
# day 1 : (0, 0) ~ (N - 1, N - 1) 의 영역이 탐색 범위가 될 수 있다.
# day 2 : day 1에서 연합이 형성된 지역 또는 해당 지역의 인접한 범위의 지역이 탐색범위가 된다.
# solution -> 방문 여부 기준이 아닌 몇일날까지 이동을 했는지 기록하여 중복되는 visited선언이 불필요하고,
# 전날에 해당되지 않은 영역을 기준으로 인접한 영역은 탐색할 필요가 없어진다. (= queue로 전날에 탐색한 범위 기록)

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
                    if cnt_nations > 1 :                # is list of united nation and real unsited nations ?
                        flag = True
                        population //= cnt_nations
                        for x, y in nations :
                            graph[x][y] = population
        if not flag : break
        day += 1
    print(day)
'''
def getUnitedInfo(x, y) :
    queue = deque([(x, y)])
    united_nations = [(x, y)]                   # maybe (x, y) is united nations
    sum_population = graph[x][y]
    while queue :
        x, y = queue.popleft()
        for nx, ny in [(x, y + 1), (x + 1, y), (x, y - 1), (x - 1, y)] :
            if 0 <= nx < N and 0 <= ny < N and days[nx][ny] != day :
                if L <= abs(graph[nx][ny] - graph[x][y]) <= R :
                    days[nx][ny] = day
                    united_nations.append((nx, ny))
                    sum_population += graph[nx][ny]
                    queue.append((nx, ny))
    cnt_nations = len(united_nations)       
    return united_nations, cnt_nations, (sum_population // cnt_nations)
    
if __name__ == "__main__" :
    N, L, R = map(int, input().split())
    graph = [[*map(int, input().split())] for _ in range(N)]
    days = [[-1] * N for _ in range(N)]
    nations = deque([(i, j) for i in range(N) for j in range(N)])
    day = 0
    while True :
        for _ in range(len(nations)) :
            x, y = nations.popleft()
            if days[x][y] != day :
                days[x][y] = day
                united_nations, cnt_nations, avg_population =  getUnitedInfo(x, y)
                if cnt_nations > 1 :       # is list of united nation and real unsited nations ?
                    for nx, ny in united_nations :
                        graph[nx][ny] = avg_population
                        nations.append((nx, ny))
        if not nations : break
        day += 1
    print(day)
