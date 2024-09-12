'''
https://www.codetree.ai/training-field/search/problems/common-divisor-multiple-2/description?page=74&pageSize=5
'''

from math import gcd
from functools import reduce

if __name__ == '__main__':
    # Input
    N = int(input())
    nums = [*map(int, input().split())]
    
    # Solve
    gcd_res = reduce(gcd, nums)
    lcm_res = reduce(lambda a, b: abs(a*b) // gcd(a, b), nums)
    
    # Output
    print(gcd_res, lcm_res)
