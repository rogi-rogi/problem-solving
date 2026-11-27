from sys import stdin

input = stdin.readline

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

if __name__ == '__main__':

    # Input
    points = [Point(*map(int, input().split())) for _ in range(int(input()))]

    # Solve
    points.sort(key=lambda x: (x.x, x.y))
    answer = [point.x * point.y for point in points]

    # Output
    print(*answer, sep='\n')