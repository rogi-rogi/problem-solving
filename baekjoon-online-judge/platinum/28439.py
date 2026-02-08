from collections import defaultdict
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N, M = map(int, input().split())
    matrix = [[*map(int, input().split())] for _ in range(N)]
    
    cnt = defaultdict(int)
    
    # 최다 빈도수(max_R) 구하기
    for i in range(N):
        cnt[matrix[0][0] - matrix[i][0]] += 1
    for j in range(M) :
        cnt[matrix[0][j]] += 1
    max_R = max_cnt = 0
    for i, c in cnt.items() :
        if c > max_cnt :
            max_R, max_cnt = i, c
            
    R = [matrix[i][0] - matrix[0][0] + max_R for i in range(N)]
    C = [matrix[0][i] - max_R for i in range(M)]
    
    for i in range(N) :
        for j in range(M) :
            if R[i] + C[j] != matrix[i][j] :
                print(-1)
                exit(0)

    print(N + M - max_cnt)
    for i in range(N) :
        if R[i] : print(1, i + 1, R[i])
    for j in range(M) :
        if C[j] : print(2, j + 1, C[j])
    
