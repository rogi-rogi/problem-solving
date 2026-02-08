N = int(input())
A, B, C = map(int, input().split())
print(sum([A if A <= N else N, B if B <= N else N, C if C <= N else N]))
