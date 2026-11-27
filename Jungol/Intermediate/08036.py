from sys import stdin
from collections import defaultdict

input = stdin.readline

if __name__ == '__main__':
    x_by_y = defaultdict(list)
    y_by_x = defaultdict(list)

    # Input
    N = int(input())
    for _ in range(N):
        x, y = map(int, input().split())
        x_by_y[y].append(x)
        y_by_x[x].append(y)

    # Solve
    answer = 0
    for y_list in x_by_y.values():
        n = len(y_list) - 1
        answer += n * (n + 1) // 2
    for x_list in y_by_x.values():
        n = len(x_list) - 1
        answer += n * (n + 1) // 2

    # Output
    print(answer)