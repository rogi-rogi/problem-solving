H1, B1 = map(int, input().split())
H2, B2 = map(int, input().split())
P1_score = 3 * H1 + B1
P2_score = 3 * H2 + B2
res = "NO SCORE"
if P1_score > P2_score : res = "1 " + str(P1_score - P2_score)
elif P1_score < P2_score : res = "2 " + str(P2_score - P1_score)
print(res)
