# 01(타겟 넘버).py
# https://school.programmers.co.kr/learn/courses/30/lessons/43165
from collections import deque

def solution(numbers, target):
    N = len(numbers)
    queue = deque([(numbers[0], 0), (-numbers[0], 0)])
    res = 0
    while queue :
        val, idx = queue.popleft()
        if idx == N - 1 and val == target : res += 1
        if idx < N - 1 :
            queue.append((val + numbers[idx + 1], idx + 1))
            queue.append((val - numbers[idx + 1], idx + 1))
    return res
