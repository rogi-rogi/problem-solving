import heapq
from sys import stdin
input = stdin.readline

n, m = map(int, input().split())
heap = []
cnt = 0
for _ in range(n) :
    P, L = map(int, input().split())
    temp = input()
    if P < L :
        heap.append(1)
    else :
        mileage_list = sorted(list(map(int, temp.split())), reverse = True)[:L]
        heap.append(mileage_list[-1])
heapq.heapify(heap)
while len(heap):
    temp = heapq.heappop(heap)
    if m < temp : break
    else : m -= temp
    cnt += 1
print(cnt)
