from heapq import heappop, heappush
from math import inf
from sys import stdin
input = stdin.readline

d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    
def dijkstra() :
    dist = [[inf] * N for _ in range(N)]
    dist[0][0] = board[0][0]
    pq = [(board[0][0], (0, 0))]
    while pq :
        w, p = heappop(pq)
        for dx, dy in d :
            nx = p[0] + dx
            ny = p[1] + dy
            if 0 <= nx < N and 0 <= ny < N :
                nw = w + board[nx][ny]
                if dist[nx][ny] > nw :
                    dist[nx][ny] = nw
                    heappush(pq, (nw, (nx, ny)))
    return dist[N - 1][N - 1]

if __name__ == "__main__" :
    TC = 1
    while True :
        N = int(input())
        if N == 0 : break
        board = [[*map(int, input().split())] for _ in range(N)]
        print(f'Problem {TC}: {dijkstra()}')
        TC += 1
