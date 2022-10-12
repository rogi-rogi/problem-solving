a1, a0 = map(int, input().split())
c = int(input())
n = int(input())
print([1, 0][(a1 > c) or (a1 == c and a0 > 0) or (a1 * n + a0 > c * n)])
