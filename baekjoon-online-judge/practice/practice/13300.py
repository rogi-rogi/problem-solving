from sys import stdin
input=stdin.readline

N, K = map(int, input().split())
students = [[0] * 2 for _ in range(7)]
for _ in range(N) :
    S, Y = map(int, input().split())
    students[Y][S] += 1
    
res = 0
for student in students :
    for i in range(2) :
        if student[i] > 0 :
            res += student[i] // K + [0, 1][student[i] % K != 0]
print(res)
