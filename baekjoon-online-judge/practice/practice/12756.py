from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    a1, h1 = map(int, input().split())
    a2, h2 = map(int, input().split())

    # Solve
    a = h1 // a2 + (1 if h1 % a2 else 0)
    b = h2 // a1 + (1 if h2 % a1 else 0)
    res = "DRAW"
    if a > b:
        res = "PLAYER A"
    elif a < b:
        res = "PLAYER B"

    # Output
    print(res)
