from sys import stdin
from collections import defaultdict

input = stdin.readline

if __name__ == '__main__':
    points_by_color = defaultdict(list)

    # Input
    N = int(input())
    for _ in range(N):
        x, color = map(int, input().split())
        points_by_color[color].append(x)

    # Solve
    answer = 0
    for points in points_by_color.values():
        if len(points) == 1:
            continue

        points.sort()
        answer += points[1] - points[0]
        answer += points[-1] - points[-2]

        for i in range(1, len(points) - 1):
            answer += min(
                points[i] - points[i - 1],
                points[i + 1] - points[i]
            )

    # Output
    print(answer)