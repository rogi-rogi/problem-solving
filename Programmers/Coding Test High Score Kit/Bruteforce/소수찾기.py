# 소수찾기.py
# https://school.programmers.co.kr/learn/courses/30/lessons/42839

import math
from itertools import permutations

def is_prime(num):
    if num < 2: return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def solution(numbers):
    numbers = list(numbers)
    N = len(numbers)
    nums = set()
    for i in range(1, N + 1):
        for perm in permutations(numbers, i):
            nums.add(int(''.join(perm)))
    
    primes = [num for num in nums if is_prime(num)]
    return len(primes)
