from collections import deque
from sys import stdin
input = stdin.readline
MAX_DISTANCE = 1000

def manhattan_distance(x1, y1, x2, y2):
    return abs(x1 - x2) + abs(y1 - y2)

def bfs():
    queue = deque([[start_x, start_y]])
    visited = [False] * n
    while queue:
        x, y = queue.popleft()
        if manhattan_distance(x, y, end_x, end_y) <= MAX_DISTANCE:
            return "happy"
        for i in range(n):
            if not visited[i] and manhattan_distance(x, y, P[i][0], P[i][1]) <= MAX_DISTANCE:
                queue.append(P[i])
                visited[i] = True
    return "sad"

if __name__ == '__main__':
    for _ in range(int(input())):
        n = int(input())
        start_x, start_y = map(int, input().split())
        P = [[*map(int, input().split())] for _ in range(n)]
        end_x, end_y = map(int, input().split())
        print(bfs())
