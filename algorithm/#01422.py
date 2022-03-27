from functools import cmp_to_key
from sys import stdin
input = stdin.readline

def compare(n1, n2) :
    if str(n1) + str(n2) > str(n2) + str(n1) : return -1
    return 1
    
if __name__ == "__main__" :
    K, N = map(int, input().split())
    nums = [int(input()) for _ in range(K)]
    nums += [max(nums)] * (N - K)
    nums.sort(key = cmp_to_key(compare))
    print(*nums, sep = '')
