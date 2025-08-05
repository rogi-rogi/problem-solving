from collections import deque
from sys import stdin
input = stdin.readline

D = [(1, 0), (0, 1), (-1, 0), (0, -1)]
CLEAN = -1
PAINT = 1

def bfs(x, y) :
    board[x][y] = CLEAN
    area = 1
    queue = deque([(x, y)])
    while queue :
        x, y = queue.popleft()
        for d in range(4) :
            nx = x + D[d][0]
            ny = y + D[d][1]
            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == PAINT :
                area += 1
                board[nx][ny] = CLEAN
                queue.append((nx, ny))
    return area
    
if __name__ == "__main__" :
    N, M = map(int, input().split())
    board = [[*map(int, input().split())] for _ in range(N)]
    cnt, max_area = 0, 0
    for i in range(N) :
        for j in range(M) :
            if board[i][j] == PAINT :
                max_area = max(max_area, bfs(i, j))
                cnt += 1
    print(cnt, max_area, sep='\n')
