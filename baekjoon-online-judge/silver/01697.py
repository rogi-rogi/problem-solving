from collections import deque
from sys import stdin

input = stdin.readline

def bfs(start, end):
    queue = deque([(start, 0)])
    visited = [False] * 100_001
    visited[start] = True
    while queue:
        cur, cnt = queue.popleft()
        if cur == end:
            return cnt
        if cur + 1 <= 100_000 and not visited[cur + 1]:
            visited[cur + 1] = True
            queue.append((cur + 1, cnt + 1))
        if cur - 1 >= 0 and not visited[cur - 1]:
            visited[cur - 1] = True
            queue.append((cur - 1, cnt + 1))
        if cur * 2 <= 100_000 and not visited[cur * 2]:
            visited[cur * 2] = True
            queue.append((cur * 2, cnt + 1))

if __name__ == '__main__':
    # Input
    N, K = map(int, input().split())

    # Solve & Output
    print(bfs(N, K))
