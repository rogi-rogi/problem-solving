from collections import deque

def eatFish(x, y) :
    queue = deque([(x, y, 0)])      # x, y, time
    eat_fish = []                   # list of fish that sharks can eat
    visited = [[False] * N for _ in range(N)]
    visited[x][y] = True
    min_time = 400                  # 20 * 20
    while queue :
        x, y, time = queue.popleft()
        for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)] :
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] :
                if graph[nx][ny] <= shark_size :    # empty area or 
                    visited[nx][ny] = True
                    if 0 < graph[nx][ny] < shark_size :
                        min_time = time
                        eat_fish.append((time + 1, nx, ny))
                    if time <= min_time : queue.append((nx, ny, time + 1))
    # sorting criteria : (1) time(=distance), (2) x(=up), (3) y(=left)
    return sorted(eat_fish)[0] if eat_fish else False
                    
if __name__ == "__main__" :
    N = int(input())
    graph = [[*map(int, input().split())] for _ in range(N)]
    shark_size, time = 2, 0
    shark, fish = [], []                # recode shark/fish location
    for i in range(N) :
        for j in range(N) :
            if 1 <= graph[i][j] <= 6 : fish.append((i, j))
            elif graph[i][j] == 9 : shark = [i, j]
    graph[shark[0]][shark[1]] = 0
    eat_cnt = 0
    x, y = shark
    while fish :
        info = eatFish(x, y)             # return [time, x, y]
        if not info : break
        time, x, y = time + info[0], info[1], info[2]
        eat_cnt += 1
        if shark_size == eat_cnt :
            shark_size += 1
            eat_cnt = 0
        graph[x][y] = 0
        fish.pop(fish.index((x, y)))
    print(time)
