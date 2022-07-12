from collections import deque

def path(x) :
    res = []
    v = x
    for _ in range(time[x] + 1) :
        res.append(str(v))
        v = move[v]
    return ' '.join(res[::-1])

def bfs() :
    if N >= K : return N - K, ' '.join(map(str, range(N, K - 1, -1)))
    queue = deque([N])
    while queue :
        x = queue.popleft()
        if x == K : break
        for nx in [x - 1, x + 1, 2 * x] :
            if 0 <= nx < MAX and not time[nx] :
                queue.append(nx)
                time[nx] = time[x] + 1
                move[nx] = x
    return time[K], path(K)
    
if __name__ == "__main__" :
    MAX = 100001
    time = [0] * MAX
    move = [0] * MAX
    N, K = map(int, input().split())
    print(*bfs(), sep = '\n')
