from sortedcontainers import SortedSet
from sys import stdin

input=stdin.readline

n, q = map(int, input().split())

points = [tuple(map(int, input().split())) for _ in range(n)]
queries = [tuple(map(int, input().split())) for _ in range(q)]

# Please write your code here.

x_list = SortedSet()
y_list = SortedSet()
for x, y in points:
    x_list.add(x)
    y_list.add(y)

prefix_sum = [[0] * (len(y_list) + 1) for _ in range(len(x_list) + 1)]

for x, y in points:
    prefix_sum[x_list.bisect_left(x) + 1][y_list.bisect_left(y) + 1] += 1
for i in range(1, len(x_list) + 1):
    for j in range(1, len(y_list) + 1):
        prefix_sum[i][j] += prefix_sum[i - 1][j] + prefix_sum[i][j - 1] - prefix_sum[i - 1][j - 1]

answer = []

for x1, y1, x2, y2 in queries:
    left = x_list.bisect_left(x1)
    right = x_list.bisect_right(x2)
    top = y_list.bisect_left(y1)
    bottom = y_list.bisect_right(y2)

    count = (
        prefix_sum[right][bottom]
        - prefix_sum[left][bottom]
        - prefix_sum[right][top]
        + prefix_sum[left][top]
    )
    answer.append(count)

print(*answer, sep='\n')