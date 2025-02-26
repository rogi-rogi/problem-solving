from sys import stdin

input = stdin.readline

def dfs(x, y, cnt, p):
    if cnt == N:
        return p
    res = 0
    visited[x][y] = True
    for dx, dy, np in D:
        nx, ny = x + dx, y + dy
        if is_valid(nx, ny):
            visited[nx][ny] = True
            res += dfs(nx, ny, cnt + 1, p * np)
            visited[nx][ny] = False
    return res

def is_valid(x, y):
    return 0 <= x < 29 and 0 <= y < 29 and not visited[x][y]

if __name__ == '__main__':
    # Input
    N, *D = map(int, input().split())
    D = [(*point, d * 0.01) for point, d in zip([(0, 1), (0, -1), (1, 0), (-1, 0)], D)]

    # Solve
    visited = [[False] * 29 for _ in range(29)]
    print(dfs(14, 14, 0, 1))
