import heapq

input()
heap = list(map(int, input().split()))
heapq.heapify(heap)
ticket_num = 1
while heap :
    if heapq.heappop(heap) != ticket_num : 
        break
    ticket_num += 1
print(ticket_num)
