S1, S2 = map(int, input().split())
res = "Accepted"
for i in range(1, S1 + S2 + 1) :
    tc, user = map(int, input().split())
    if tc != user :
        res = "Wrong Answer" if i <= S1 else "Why Wrong!!!"
        break
print(res)
