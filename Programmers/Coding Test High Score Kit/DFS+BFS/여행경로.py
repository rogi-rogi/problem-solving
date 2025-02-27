# https://school.programmers.co.kr/learn/courses/30/lessons/43164
# 여행경로.py

from collections import defaultdict

def solution(tickets):
    graph = defaultdict(list)
    for u, v in tickets:
        graph[u].append(v)
    for key in graph.keys():
        graph[key].sort(reverse=True)
        
    path = ["ICN"]
    res = []
    while path:
        cur = path[-1]
        if len(graph[cur]) > 0:
            path.append(graph[cur].pop())
        else :
            res.append(path.pop())
    return res[::-1]
