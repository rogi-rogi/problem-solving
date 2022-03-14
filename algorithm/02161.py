from collections import deque

queue = deque([i for i in range(1, int(input()) + 1)])
while len(queue) > 1 :
    print(queue.popleft(), end = ' ')
    queue.append(queue.popleft())
print(queue.popleft())
