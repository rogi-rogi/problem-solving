from collections import deque
from sys import stdin
input = stdin.readline

wait = deque([])
SIZE = 0
cnt, last = 0, 100000
for _ in range(int(input())) :
    info = [*map(int, input().split())]
    if info[0] == 1 :
        wait.append(info[1])
        SIZE += 1
        if SIZE >= cnt :
            if SIZE > cnt :
                cnt += 1
                last = info[1]
            last = min(last, info[1])
    elif wait :
        wait.popleft()
        SIZE -= 1
print(cnt, last)
