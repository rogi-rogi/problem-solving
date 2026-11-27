from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        # Solve & Output
        print(input().rstrip()[::-1])
