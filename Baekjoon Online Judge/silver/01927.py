from heapq import heappush, heappop
from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    heap = []
    res = []

    # Input
    for _ in range(int(input())) :
        x = int(input())

        # Solve
        if x == 0 :
            res.append(heappop(heap) if heap else 0)
        else :
            heappush(heap, x)

    # Output
    print(*res, sep='\n')