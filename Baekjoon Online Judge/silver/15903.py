import heapq
from sys import stdin
input = stdin.readline

n, m = map(int, input().split())
heap = list(map(int, input().split()))
heapq.heapify(heap)
for _ in range(m) :
    temp = heapq.heappop(heap) + heapq.heappop(heap)
    heapq.heappush(heap, temp)
    heapq.heappush(heap, temp)
print(sum(heap))
