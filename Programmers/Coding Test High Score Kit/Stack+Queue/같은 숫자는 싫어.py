# 같은 숫자는 싫어.py
# https://school.programmers.co.kr/learn/courses/30/lessons/12906

def solution(arr) :
    res = [arr[0]]
    for i in range(1, len(arr)) :
        if arr[i] != res[-1] :
            res.append(arr[i])
    return res
