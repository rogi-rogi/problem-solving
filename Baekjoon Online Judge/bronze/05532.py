L = int(input())
A = int(input())
B = int(input())
q1, r1 = divmod(A, int(input()))
if r1 > 0 : q1 += 1
q2, r2 = divmod(B, int(input()))
if r2 > 0 : q2 += 1
print(L - max(q1, q2))
