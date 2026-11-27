N = int(input()) ** 2
if N == 1 : print(0)
else :
    q, r = divmod(N, 2)
    print(q + [0, 1][r != 0])
