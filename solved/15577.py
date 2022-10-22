import heapq
from sys import stdin
input = stdin.readline

heap = [int(input()) for _ in range(int(input()))]
heapq.heapify(heap)
while len(heap) > 1 :
    heapq.heappush(heap, (heapq.heappop(heap) + heapq.heappop(heap)) / 2)
print("%.6f" %heapq.heappop(heap))
