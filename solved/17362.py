N = int(input())
N %= 8
res = 0
if N == 1 : res = 1
elif N == 0 or N == 2 : res = 2
elif N == 3 or N == 7 : res = 3
elif N == 4 or N == 6 : res = 4
else : res = 5
print(res)
