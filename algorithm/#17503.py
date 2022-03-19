import heapq
from sys import stdin
input = stdin.readline

N, M, K = map(int, input().split())
v = 0
heap = []
for bear in sorted([list(map(int, input().split()))[::-1] for _ in range(K)]) :
    v += bear[1] 
    heapq.heappush(heap, bear[1])
    if len(heap) > N : v -= heapq.heappop(heap)
    if len(heap) == N and v >= M :
        print(bear[0])
        exit(0)
print(-1)
