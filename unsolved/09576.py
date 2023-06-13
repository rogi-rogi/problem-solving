from sys import stdin
input = stdin.readline

# if __name__ == "__main__" :
#     for _ in range(int(input())) :
#         N, M = map(int, input().split())
#         graph = [[*map(int, input().split())] for _ in range(M)]
#         graph.sort(key = lambda x : x[1])
#         match = [False] * (N + 1)
#         cnt = 0
#         for a, b in graph :
#             for i in range(a, b + 1) :
#                 if not match[i] :
#                     cnt += 1
#                     match[i] = True
#                     break
#         print(cnt)

def bipartite_matching(N, M) :
    match = [0] * (N + 1)
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
    for i in range(1, M + 1) :
        visited = [False] * (N + 1)
        if dfs(i) : 
            maximum_flow += 1
            if maximum_flow == N : break
    return maximum_flow

if __name__ == "__main__" :
    for _ in range(int(input())) :
        N, M = map(int, input().split())
        graph = [[] for _ in range(M + 1)]
        for i in range(1, M + 1) :
            a, b = map(int, input().split())
            graph[i] = [*range(a, b + 1)]
        print(bipartite_matching(N, M))
