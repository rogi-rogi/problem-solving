# 01(포켓몬).py
# https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=python3

def solution(nums):
    half_N_len = len(nums) // 2
    set_nums_len = len(set(nums))
    return [set_nums_len, half_N_len][set_nums_len > half_N_len]
