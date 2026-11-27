from bisect import bisect_left, bisect_right
from sys import stdin

input=stdin.readline

n, q = map(int, input().split())
points = list(map(int, input().split()))
queries = [tuple(map(int, input().split())) for _ in range(q)]

# Please write your code here.
answer = []

for a, b in queries:
    left = bisect_left(points, a)
    right = bisect_right(points, b)
    answer.append(right - left)

print(*answer, sep='\n')