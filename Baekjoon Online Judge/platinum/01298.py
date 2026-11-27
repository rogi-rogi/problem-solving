from sys import stdin
input = stdin.readline

def bipartite_matching() :
    match = [0] * SIZE
    visited = None
    
    def dfs(v1) :
        visited[v1] = True
        for v2 in graph[v1] :
            if not match[v2] or not visited[match[v2]] and dfs(match[v2]) :
                match[v2] = v1
                return True
        return False
        
    maximum_flow = 0
    for i in range(1, SIZE) :
        visited = [False] * SIZE
        if dfs(i) :
            maximum_flow += 1
            if maximum_flow == N : break
    return maximum_flow

if __name__ == "__main__" :
    N, M = map(int, input().split())
    SIZE = N + 1
    graph = [[] for _ in range(N + 1)]
    for _ in range(M) :
        a, b = map(int, input().split())
        graph[a].append(b)
    print(bipartite_matching())
