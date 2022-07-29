from heapq import heappush, heappop
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    rooms = sorted([[*map(int, input().split())] for i in range(N)])
    pq = []
    heappush(pq, rooms[0][1])
    for i in range(1, N) :
        if pq[0] > rooms[i][0] :
            heappush(pq, rooms[i][1])
        else :
            heappop(pq)
            heappush(pq, rooms[i][1])
    print(len(pq))
