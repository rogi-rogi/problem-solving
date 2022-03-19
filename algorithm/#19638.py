import heapq
from sys import stdin
input = stdin.readline

N, H_centi, T = map(int, input().split())
heap = []
cnt = 0
for _ in range(N) :
    heapq.heappush(heap, -int(input()))
for _ in range(T) :
    temp = -heapq.heappop(heap)
    if temp < H_centi :
        heapq.heappush(heap, temp)
        break
    elif temp != 1 :
        cnt += 1
        heapq.heappush(heap, - (temp // 2))
    else : heapq.heappush(heap, -1)
temp = -heapq.heappop(heap)
if temp < H_centi :
    print("YES")
    print(cnt)
else :
    print("NO")
    print(temp)
