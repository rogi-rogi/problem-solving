score1 = [*map(int, input().split())]
score2 = [*map(int, input().split())]
point = [6, 3, 2, 1, 2]
for i in range(5) :
    score1[i] *= point[i]
    score2[i] *= point[i]
print(sum(score1), sum(score2))
