from sys import stdin
input = stdin.readline

point = [[*map(int, input().split())] for _ in range(int(input()))]
point.sort()
width = point[-1][0] - point[0][0]
point.sort(key=lambda x : x[1])
height = point[-1][1] - point[0][1]
print(width * height)
