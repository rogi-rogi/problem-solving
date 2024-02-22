# 03(H-Index).py
# https://school.programmers.co.kr/learn/courses/30/lessons/42747
def solution(citations):
    N = len(citations)
    citations.sort()
    h_index = 0
    for i in range(N):
        if citations[i] >= N - i:
            h_index +=1
    return h_index
