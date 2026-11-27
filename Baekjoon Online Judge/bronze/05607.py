from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    A, B = 0, 0
    for _ in range(int(input())):
        c1, c2 = map(int, input().split())
        if c1 == c2:
            A += c1
            B += c1
        elif c1 > c2:
            A += c1 + c2
        elif c1 < c2:
            B += c1 + c2
    print(A, B)
