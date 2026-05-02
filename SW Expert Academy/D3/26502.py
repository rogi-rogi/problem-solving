from collections import defaultdict

MIN, MAX = 0, 1

def solve():
    y_bounds_by_x = defaultdict(lambda: [0, 0])
    x_bounds_by_y = defaultdict(lambda: [0, 0])
    for x, y in points:
        y_bounds_by_x[x][MAX] = max(y_bounds_by_x[x][MAX], y)
        y_bounds_by_x[x][MIN] = min(y_bounds_by_x[x][MIN], y)
        x_bounds_by_y[y][MAX] = max(x_bounds_by_y[y][MAX], x)
        x_bounds_by_y[y][MIN] = min(x_bounds_by_y[y][MIN], x)

    max_area = 0
    for x, y in points:
        min_x, max_x = x_bounds_by_y[y]
        min_y, max_y = y_bounds_by_x[x]
        width = max(abs(x - min_x), abs(x - max_x))
        height = max(abs(y - min_y), abs(y - max_y))
        max_area = max(max_area, width * height)

    return max_area


if __name__ == '__main__':
    # Input
    answer = []

    for _ in range(int(input())):
        points = [tuple(map(int, input().split())) for _ in range(int(input()))]
        # Solve
        answer.append(solve())

    # Output
    print(*answer, sep='\n')