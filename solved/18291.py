from sys import stdin
input = stdin.readline

for _ in range(int(input())) :
    N = int(input())
    print(pow(2, N - (2 if N >= 2 else 1), int(1e9 + 7)))
