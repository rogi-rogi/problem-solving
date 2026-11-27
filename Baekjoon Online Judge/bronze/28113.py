N, A, B = map(int, input().split())
res = "Bus"
if B < A : res = "Subway"
elif A == B : res = "Anything"
print(res)
