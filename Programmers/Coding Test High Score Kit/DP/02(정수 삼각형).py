# 02(정수 삼각형).py
# https://school.programmers.co.kr/learn/courses/30/lessons/43105
def solution(triangle):
    N = len(triangle)
    memo = [[0] * N for _ in range(N)] 
    memo[0][0] = triangle[0][0]
    for i in range(1, N) :
        for j in range(i + 1) :
            memo[i][j] = triangle[i][j] + max(memo[i - 1][j - 1], memo[i - 1][j])
            # j = 0, memo[i-1][j - 1] == memo[i-1][-1] = 0
    return max(memo[N - 1])
