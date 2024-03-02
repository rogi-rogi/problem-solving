# 최소직사각형.py
# https://school.programmers.co.kr/learn/courses/30/parts/12230

def solution(sizes):
    max_w, max_h = 0, 0
    for w, h in sizes :
        max_w = max(max_w, [w, h][h > w])
        max_h = max(max_h, [h, w][h > w])
    return max_w * max_h
