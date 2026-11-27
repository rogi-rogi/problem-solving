from sys import stdin
input = stdin.readline

MOD = int(1e9 + 7)
res = 0
for _ in range(int(input())) :
    C, K = map(int, input().split())
    res = (res + C * K * pow(2, K - (1 if K > 1 else K), MOD)) % MOD
print(res)
