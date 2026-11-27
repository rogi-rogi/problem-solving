T = int(input())
score = [0] * 5

temp = [*map(int, input().split())]
for i in range(T) :# 국어, 수학, 영어, 탐구, 제2외국어
    score[i] = temp[i]
res = [0, 0, 0]
res[0] = abs(score[0] - score[2])* [108, 508][score[0] > score[2]]
res[1] = abs(score[1] - score[3])* [305, 212][score[1] > score[3]]
res[2] = [0, score[4] * 707][T == 5]
print(sum(res)*4763)
