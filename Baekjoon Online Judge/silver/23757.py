import heapq
from sys import stdin
input = stdin.readline

N, M = map(int, input().split())
heap = []
for i in list(map(int, input().split())) :
    heapq.heappush(heap, -i)

result = 1
for i in list(map(int, input().split())) :
    temp = -heapq.heappop(heap)
    if temp - i < 0 :
        result = 0
        break
    heapq.heappush(heap, -(temp - i))
print(result)
