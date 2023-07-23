S = int(input())
A = int(input())
B = int(input())
res = 250
if S > A :
    res += 100*((S-A)//B + [1, 0][(S - A) % B == 0])
print(res)
