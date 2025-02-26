# https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=python3
# 네트워크.py

from collections import deque

def bfs(start, visited, computers, n):
    queue = deque([start])
    visited[start] = True
    while queue:
        cur = queue.popleft()
        for i in range(n):
            if not visited[i] and computers[cur][i] == 1 and cur != i:
                visited[i] = True
                queue.append(i)
        

def solution(n, computers):
    visited = [False] * n
    
    cnt = 0
    for i in range(n):
        if not visited[i]:
            bfs(i, visited, computers, n)
            cnt += 1
    return cnt;
