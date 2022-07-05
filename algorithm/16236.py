from collections import deque

def bfs(x, y) :
    queue = deque([(x, y, 0)])
    move_list = []
    visited = [[False] * N for _ in range(N)]
    visited[x][y] = True
    min_move = 400 # 20*20
    while queue :
        x, y, move = queue.popleft()
        for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)] :
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] :
                if board[nx][ny] <= shark_size :
                    visited[nx][ny] = True
                    if 0 < board[nx][ny] < shark_size :
                        min_move = move
                        move_list.append((move + 1, nx, ny))
                    if move <= min_move : queue.append((nx, ny, move + 1))
    return sorted(move_list)[0] if move_list else False
                    
if __name__ == "__main__" :
    N = int(input())
    board = [[*map(int, input().split())] for _ in range(N)]
    shark_size, time = 2, 0
    shark, fish = [], []
    for i in range(N) :
        for j in range(N) :
            if 1 <= board[i][j] <= 6 : fish.append((i, j))
            elif board[i][j] == 9 : shark = [i, j]
    board[shark[0]][shark[1]] = 0
    eat_cnt = 0
    x, y = shark
    while fish :
        res = bfs(x, y)
        if not res : break
        x, y = res[1], res[2]
        time += res[0]
        eat_cnt += 1
        if shark_size == eat_cnt :
            shark_size += 1
            eat_cnt = 0
        board[x][y] = 0
        fish.pop(fish.index(res[1:]))
    print(time)
    
