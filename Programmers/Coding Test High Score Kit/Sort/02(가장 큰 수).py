# 02(가장 큰 수).py
# https://school.programmers.co.kr/learn/courses/30/lessons/42746
from functools import cmp_to_key

def compare(a, b):
    return [-1, 1][a + b < b + a]

def solution(numbers):
    numbers = [*map(str, numbers)]
    numbers = sorted(numbers, key=cmp_to_key(compare))
    return str(int(''.join(numbers)))
