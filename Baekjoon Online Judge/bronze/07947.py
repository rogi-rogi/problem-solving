from sys import stdin
input = stdin.readline

MAX = 10

def round(num):
    return int(num) + (1 if num - int(num) >= 0.5 else 0)

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        red, green, blue = 0.0, 0.0, 0.0

        for _ in range(MAX):
            r, g, b = map(float, input().split())
            # Solve
            red += r
            green += g
            blue += b

        # Output
        print(f"{round(red / MAX)} {round(green / MAX)} {round(blue / MAX)}")
