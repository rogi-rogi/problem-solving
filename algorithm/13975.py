import heapq
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    for _ in range(int(input())) :
        input()
        nums = list(map(int, input().split()))
        result = 0
        heapq.heapify(nums)
        while len(nums) > 1 :
            sum_num = heapq.heappop(nums) + heapq.heappop(nums)
            result += sum_num
            heapq.heappush(nums, sum_num)
        print(result)
