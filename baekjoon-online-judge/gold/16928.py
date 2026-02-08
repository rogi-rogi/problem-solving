from collections import deque
from sys import stdin
input = stdin.readline

def BFS() :
    visited = [0] * 101
    queue = deque([1])
    while queue :
        num = queue.popleft()
        for next_num in [*range(num + 1, num + 7)] :
            if next_num == 100 : return visited[num] + 1
            if next_num < 100 :
                if next_num in jump.keys() : next_num = jump[next_num]
                if not visited[next_num] :
                    visited[next_num] = visited[num] + 1
                    queue.append(next_num)
    return visited[100]
                
if __name__ == "__main__" :
    N, M = map(int, input().split())
    jump = dict()
    for _ in range(N + M) :
        x, y = map(int, input().split())
        jump[x] = y
    print(BFS())
