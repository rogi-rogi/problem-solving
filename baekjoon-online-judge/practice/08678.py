from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        a, b = map(int, input().split())

        # Solve & Output
        print(["NIE", "TAK"][b % a == 0])
