from heapq import heappush, heappop
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    for _ in range(int(input())) :
        M = int(input())
        nums = []
        line = (M-1) // 10 + 1
        for _ in range(line) :
            nums += list(map(int, input().split()))
        left_max_heap = []
        right_min_heap = []
        result = list()
        for i in range(M) :
            if len(left_max_heap) == len(right_min_heap) :
                heappush(left_max_heap, -nums[i])
            else : heappush(right_min_heap, nums[i])
            if right_min_heap and -left_max_heap[0] > right_min_heap[0] :
                heappush(left_max_heap, -heappop(right_min_heap))
                heappush(right_min_heap, -heappop(left_max_heap))
            if i % 2 == 0 :
                result.append(-left_max_heap[0])
        cnt = (M-1) // 2 + 1
        print(cnt)
        for i in range(0, len(result), 10) :
            print(*result[i: i + 10])
