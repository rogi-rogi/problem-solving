from sys import stdin
input = stdin.readline

N = int(input())
rooms = [[*map(int, input().split())] for _ in range(N)]
rooms.sort(key = lambda x : x[0])
rooms.sort(key = lambda x : x[1])
cnt, end = 0, 0
for s, e in rooms :
    if s >= end :
        end = e
        cnt += 1
    else : continue
print(cnt)
