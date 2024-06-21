from collections import defaultdict

def solution(edges):
    graph = defaultdict(lambda: [0, 0]) # (out, in)
    answer = [0] * 4 # 중앙, 도넛, 막대, 8자
    for v1, v2 in edges:
        graph[v1][0] += 1
        graph[v2][1] += 1
    for node in graph:
        if graph[node][0] == 0: # 막대 그래프
            answer[2] += 1
        elif graph[node][0] == 2:
            if graph[node][1] > 0: # 8자 그래프
                answer[3] += 1
            else: # 중앙
                answer[0] = node 
        elif graph[node][0] > 2: # 중앙
            answer[0] = node
    answer[1] = graph[answer[0]][0] - answer[2] - answer[3]
    return answer
