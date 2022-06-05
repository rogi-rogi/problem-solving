#default ver. N -> K
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

'''
#fast ver. K -> N
from collections import deque

def bfs() :
    if N >= K : return N - K, 1
    queue = deque([(K, 0)])
    visited = [False] * MAX
    cnt, std_time = 0, MAX
    while queue :
        x, time = queue.popleft();
        visited[x] = True
        if time > std_time : continue
        if x == N :
            if time < std_time :
                std_time = time
            cnt += 1
        else :
            for nx in [x - 1, x + 1] :
                if 0 <= nx < MAX and not visited[nx] :
                    if time + 1 <= std_time :
                        queue.append((nx, time + 1))
            nx = x // 2
            if x % 2 == 0 and not visited[nx] :
                if time + 1 <= std_time :
                    queue.append((nx, time + 1))
    return std_time, cnt

if __name__ == "__main__" :
    MAX = 100001
    N, K = map(int, input().split())
    print(*bfs(), sep = '\n')
'''
