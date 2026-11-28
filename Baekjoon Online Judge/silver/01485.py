from itertools import combinations
from sys import stdin

input=stdin.readline


def is_square(points):
    squared_distances = []
    for (x1, y1), (x2, y2) in combinations(points, 2):
        squared_distances.append((x1 - x2) ** 2 + (y1 - y2) ** 2)
        
    squared_distances.sort()
    squared_a = squared_distances[0]
    return squared_distances == [squared_a] * 4 + [2 * squared_a] * 2


if __name__ == '__main__':
    for _ in range(int(input())):
        points = [tuple(map(int, input().split())) for _ in range(4)]
        print(int(is_square(points)))