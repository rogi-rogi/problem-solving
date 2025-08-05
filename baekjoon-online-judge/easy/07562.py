from collections import deque
from sys import stdin
input = stdin.readline

dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [-1, 1, -2, 2, -2, 2, -1, 1]

def bfs(x, y, fx, fy, l) :
    if x == fx and y == fy : return 0
    board[x][y] = 1
    queue = deque([(x, y)])
    while queue :
        x, y = queue.popleft()
        for i in range(8) :
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < l and 0 <= ny < l and board[nx][ny] == 0 :
                if nx == fx and ny == fy : return board[x][y]
                board[nx][ny] = board[x][y] + 1
                queue.append((nx, ny))

if __name__ == "__main__" :
    board = None
    for _ in range(int(input())) :
        l = int(input())
        board = [[0] * l for _ in range(l)]
        x, y = map(int, input().split())
        fx, fy = map(int, input().split())
        print(bfs(x, y, fx, fy, l))
