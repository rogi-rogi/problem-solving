from collections import deque

def bfs() :
    if N >= K : return N - K, 1
    queue = deque([(N, 0)])
    visited = [False] * MAX
    cnt, std_time = 0, MAX
    while queue :
        x, time = queue.popleft();
        visited[x] = True
        if time > std_time : continue
        if x == K :
            if time < std_time : std_time = time
            cnt += 1
        else :
            for nx in [x - 1, x + 1, 2 * x] :
                if 0 <= nx < MAX and not visited[nx] :
                    queue.append((nx, time + 1))
    return std_time, cnt

if __name__ == "__main__" :
    MAX = 100001
    N, K = map(int, input().split())
    print(*bfs(), sep = '\n')
