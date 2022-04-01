import heapq
from sys import stdin
input = stdin.readline

heap = []
for _ in range(int(input())) :
    temp = int(input())
    if temp == 0 :
        print(heapq.heappop(heap) if heap else 0)
    else : heapq.heappush(heap, temp)
