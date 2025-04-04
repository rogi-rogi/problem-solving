from heapq import heapify, heappush, heappop
from sys import stdin

input = stdin.readline

if __name__ == "__main__" :
    # Input
    heap = [int(input()) for _ in range(int(input()))]

    # Solve
    res = 0
    heapify(heap)
    while len(heap) > 1 :
        new_cart = heappop(heap) + heappop(heap)
        res += new_cart
        heappush(heap, new_cart)

    # Output
    print(res)