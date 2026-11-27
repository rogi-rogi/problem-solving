from sys import stdin
input = stdin.readline

for _ in range(int(input())) :
    V, E = map(int, input().split())
    print((V - E - 2) * -1)
