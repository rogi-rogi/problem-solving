'''
bipartite matching
양쪽 그래프의 정점들을 매칭시키는 알고리즘.

[Time Complexity] : O( VE ) = O( (N + M)E )
N, M : 그룹 N, M의 인원 수, ( 1 <= N, M <= SIZE )
E    : 그룹 N, M을 연결하는 간선의 수

기본적으로 N <= M 일 때 성립한다.
때문에, N > M  일 때는 IndexError이 발생할 수 있으니 match, visited의 크기를 N과 M 그룹 중 더 큰 수를 기준으로 하자.
배열의 크기를 늘리는 방법 이외에 탐색과정에서 N과 M의 대소비교에 따른 전처리를 통해서 IndexError가 발생하지 않게 할 수 있다.

만약 N, M의 최댓값(SIZE)이 동일하다면 처음부터 match, visited의 크기를 SIZE로 해도 된다.
'''
def bipartite_matching(N, M) :
    if N > M : M = N # N <= M 으로 필요한 만큼 증가
    match = [0] * (M + 1) # 그룹 M의 i번째 정점에 대해 매칭된 그룹 N의 요소
    visited = None
    
    def dfs(v1) :
        for v2 in graph[v1] :
            if not visited[v2] : 
                visited[v2] = True
                if not match[v2] or dfs(match[v2]) :
                    match[v2] = v1
                    return True
        return False
    
    maximum_flow = 0
    for i in range(1, N + 1) :
        visited = [False] * (M + 1)
        if dfs(i) : 
            maximum_flow += 1
            if maximum_flow == N : break # N개에 대해 maximun matching 성립, 더이상 탐색 불필요
    return maximum_flow

if __name__ == "__main__" :
    N, M, E = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    for _ in range(E) :
        v1, v2 = map(int, input().split())
        graph[v1].append(v2)
    maximum_flow = bipartite_matching(N, M)
    print(maximum_flow)
