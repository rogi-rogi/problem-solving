#default ver
from collections import deque

N, K = map(int, input().split())
queue = deque([i for i in range(1, N + 1)])
result = []
cnt = 0
while queue :
    cnt += 1
    temp = queue.popleft()
    if cnt == K :
        cnt = 0
        result.append(temp)
    else : queue.append(temp)
print('<'+str(result)[1:-1]+'>')


#fast ver
N, K = map(int, input().split())
queue = list(range(1, N + 1))
result = []
idx = 0
while queue:
    idx = (idx + K - 1) % len(queue)
    result.append(queue.pop(idx))
print('<'+str(result)[1:-1]+'>')
