'''
bipartite matching
양쪽 그래프의 정점들을 매칭시키는 알고리즘.

[Time Complexity] : O( VE ) = O( (N + M)E )
N, M : 그룹 N, M의 인원 수
E    : 그룹 N, M을 연결하는 간선의 수

N <= M 일 때 성립한다.
N > M 일떄는 두 그룹을 맞바꾸는 정석적인 방법과, 단순히 match의 크기를 N으로 하는 방법이 있다.
후자의 경우 결과의 신뢰성과 알고리즘의 최적성이 보장되지 않는다.
때문에 reverse_graph()를 사용해 역방향 그래프로 변환하고, N과 M도 맞바꾸어야 한다.
'''
def reverse_graph() :
    reverse_graph = [[] for _ in range(N + 1)]
    for v1, edges in enumerate(graph) :
        for v2 in edges :
            reverse_graph[v2].append(v1)
    return reverse_graph

def bipartite_matching() :
    if N > M :
        graph = reverse_graph()
        N, M = M, N
    match = [0] * (M + 1) # 그룹 M의 i번째 정점에 대해 매칭된 그룹 N의 요소
    visited = None
    
    def dfs(v1) :
        visited[v1] = True
        for v2 in graph[v1] :
            if not visited[v2] : 
                if not match[v2] or dfs(match[v2]) :
                    match[v2] = v1
                    return True
        return False
    
    maximum_flow = 0
    for i in range(1, N + 1) :
        visited = [False] * (M + 1)
        if dfs(i) : maximum_flow += 1
    return maximum_flow

if __name__ == "__main__" :
    N, M, E = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    for _ in range(E) :
        v1, v2 = map(int, input().split())
        graph[v1].append(v2)
    maximum_flow = bipartite_matching()
    print(maximum_flow)
