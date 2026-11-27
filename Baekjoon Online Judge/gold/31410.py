from sys import stdin
input = stdin.readline
INF = -int(10**10)

N = int(input())
P = [[INF, INF]] + [[*map(int, input().split())] for _ in range(N)]
P.sort(key=lambda x : (x[0], x[1]))
res = [0] * (N+1)

L1 = P[1][1]
use = 1
for i in range(2, N + 1) :
    L1 += P[i][1] + (P[i][0] - P[i - 1][0])*use
    use += 1

L2 = P[N][1]                                                                                                                                                                                                                                                                                                                                    
use = 1
for i in range(N - 1, 0, -1) :
    L2 += P[i][1] + (P[i + 1][0] - P[i][0])*use
    use += 1


res[1] = min(L1 - (P[1][1] + P[N][0] - P[1][0]), L2 - (P[1][1] + (N-1)*(P[2][0] - P[1][0])))
res[N] = min(L1 - (P[N][1] + (N-1)*(P[N][0] - P[N-1][0])), L2 - (P[N][1] + (P[N][0] - P[1][0])))
for i in range(2, N) :
    res[i] = min(L1 - (P[i][1] + P[N][0] - P[i][0]), L2 - (P[i][1] + P[i][0] - P[1][0]))

del res[0]
print(min(*res))
