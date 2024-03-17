from collections import deque
from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    queue = deque([])
    res = []
    for _ in range(int(input())):
        cmd, *args = input().split()
        if cmd == 'push':
            queue.append(int(*args))
        elif cmd == 'pop':
            res.append(queue.popleft() if queue else -1)
        elif cmd == 'size':
            res.append(len(queue))
        elif cmd == 'empty':
            res.append(0 if queue else 1)
        elif cmd == 'front':
            res.append(queue[0] if queue else -1)
        elif cmd == 'back':
            res.append(queue[-1] if queue else -1)
    print(*res, sep='\n')
