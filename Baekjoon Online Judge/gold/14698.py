import heapq
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    for _ in range(int(input())) :
        mod = int(1e9) + 7
        input()
        nums = list(map(int, input().split()))
        result = 1
        heapq.heapify(nums)
        while len(nums) > 1 :
            sum_num = heapq.heappop(nums) * heapq.heappop(nums)
            result = result * sum_num % mod
            heapq.heappush(nums, sum_num)
        print(result)
