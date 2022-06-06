from sys import stdin
input = stdin.readline

N = int(input())
rooms = [[*map(int, input().split())] for _ in range(N)]
rooms.sort(key = lambda x : x[0])
rooms.sort(key = lambda x : x[1])
cnt, end = 0, 0
for i in rooms :
    if i[0] >= end :
        end = i[1]
        cnt += 1
    else : continue
print(cnt)
