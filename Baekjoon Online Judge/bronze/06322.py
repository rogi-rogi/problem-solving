from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    no = 1
    while True:
        a, b, c = map(int, input().split())
        if a == b == c == 0:
            break
        print(f"Triangle #{no}")
        no += 1
        if c == -1:
            print(f"c = {((a ** 2 + b ** 2) ** 0.5):.3f}")
        elif a == -1 and c > b:
            print(f"a = {((c ** 2 - b ** 2) ** 0.5):.3f}")
        elif b == -1 and c > a:
            print(f"b = {((c ** 2 - a ** 2) ** 0.5):.3f}")
        else:
            print("Impossible.")
        print()
