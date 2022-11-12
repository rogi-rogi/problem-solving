from heapq import heappop, heappush
from sys import stdin
input = stdin.readline

N, H_centi, T = map(int, input().split())
heap = []
cnt = 0
for _ in range(N) : 
    heappush(heap, -int(input()))
for _ in range(T) :
    temp = -heappop(heap)
    if temp < H_centi :
        heappush(heap, temp)
        break
    elif temp != 1 :
        cnt += 1
        heappush(heap, - (temp // 2))
    else : heappush(heap, -1)
    
temp = -heappop(heap)
if temp < H_centi : print("YES", cnt, sep = '\n')
else : print("NO", temp, sep = '\n')
