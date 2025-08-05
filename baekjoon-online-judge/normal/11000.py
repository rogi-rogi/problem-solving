from heapq import heappop, heappush
from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    room_list = sorted([[*map(int, input().split())] for _ in range(N)])
    pq = [0]

    # Solve
    for s, t in room_list:
        heappush(pq, t)
        if pq[0] <= s:
            heappop(pq)

    # Output
    print(len(pq))
