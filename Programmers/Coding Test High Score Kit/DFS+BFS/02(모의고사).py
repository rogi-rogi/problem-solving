# 02(모의고사).py
# https://school.programmers.co.kr/learn/courses/30/lessons/42840
def solution(answers):
    select = [
        [1, 2, 3, 4, 5], 
        [2, 1, 2, 3, 2, 4, 2, 5], 
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]
    cnt = [[0, 1], [0, 2], [0, 3]]
    for i in range(len(answers)) :
        if select[0][i % 5] == answers[i] : cnt[0][0] += 1
        if select[1][i % 8] == answers[i] : cnt[1][0] += 1
        if select[2][i % 10] == answers[i] : cnt[2][0] += 1
    cnt.sort(reverse=True)
    res = [cnt[0][1]]
    if cnt[0][0] == cnt[1][0] :
        res.append(cnt[1][1])
        if cnt [0][0] == cnt[2][0] :
            res.append(cnt[2][1])
    return sorted(res)
