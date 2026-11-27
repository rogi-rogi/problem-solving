import heapq
from sys import stdin
input = stdin.readline

heap = []
for i in range(int(input())) :
    temp = list(map(int, input().split()))
    if temp[0] == 0 :
        print(-heapq.heappop(heap) if heap else -1)
    else :
        for i in temp[1:] :
            heapq.heappush(heap, -i)
