a1, a0 = map(int, input().split())
c = int(input())
n0 = int(input())
print([1, 0][(a1 > c) or (a1 == c and a0 > 0) or (a1 * n0 + a0 > c * n0)])
# (c - a1) * n - a0 >= 0, c - a1 >= 0, n0을 만족하면 n0 <= 도 만족한다.
