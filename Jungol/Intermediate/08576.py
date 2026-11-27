from sys import stdin

input=stdin.readline

class Rect:
    def __init__(self, width, height):
        self.width = width
        self.height = height

def solve():
    a = Rect[0].width * Rect[1].width
    b = Rect[0].height * Rect[1].height
    c = Rect[2].width * Rect[3].width
    d = Rect[2].height * Rect[3].height

    left_area = a * b
    right_area = c * d

    if left_area < right_area:
        return "Left_Small"
    elif left_area > right_area:
        return "Right_Small"
    else:
        return "Same"

if __name__ == '__main__':
    # Input
    rects = [Rect(*map(int, input().split())) for _ in range(4)]

    # Solve & Output
    print(solve())