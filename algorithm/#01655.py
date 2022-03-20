from heapq import heappush, heappop
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    nums = [int(input()) for _ in range(int(input()))]
    left_max_heap = []
    right_min_heap = []
    for num in nums :
        if len(left_max_heap) == len(right_min_heap) :
            heappush(left_max_heap, -num)
        else : heappush(right_min_heap, num)
        if right_min_heap and -left_max_heap[0] > right_min_heap[0] :
            heappush(left_max_heap, -heappop(right_min_heap))
            heappush(right_num, -heappop(left_max_heap))
        print(-left_max_heap[0])
