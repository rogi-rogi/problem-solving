N, M = map(int, input().split())
if N == M : print(2*N)
else : print(2*min(N, M) +1)