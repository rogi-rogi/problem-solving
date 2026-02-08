from heapq import heappop, heappush

N, M, K = map(int, input().split())
v = 0
heap = []
res = -1
for bear in sorted([[*map(int, input().split())][::-1] for _ in range(K)]) :
    v += bear[1] 
    heappush(heap, bear[1])
    if len(heap) == N :
        if v >= M :
            res = bear[0]
            break
        else : v -= heappop(heap)
print(res)
