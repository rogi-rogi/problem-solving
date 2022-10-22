from collections import deque

def bfs() :
    if N >= K : return N - K
    queue = deque([N])
    time = [0] * 100001
    while queue :
        x = queue.popleft()
        if x == K : break
        for nx in [x - 1, x + 1, 2 * x] :
            if 0 <= nx <= 100000 and not time[nx] :
                queue.append(nx)
                time[nx] = time[x] + 1
    return time[K]
    
N, K = map(int, input().split())
print(bfs())
