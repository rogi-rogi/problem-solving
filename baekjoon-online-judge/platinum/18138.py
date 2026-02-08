from sys import stdin
input = stdin.readline

def make_sailor_suit(shirt, collar) :
    return (shirt / 2 <= collar <= shirt * 3/4) or (shirt <= collar <= shirt * 5/4) 

def bipartite_matching() :
    match = [-1] * M
    visited = None
    
    def dfs(v1) :
        shirt_width = shirts[v1]
        for v2, collar_width in enumerate(collars) :
            if not visited[v2] and make_sailor_suit(shirt_width, collar_width) :
                visited[v2] = True
                if match[v2] == -1 or dfs(match[v2]) :
                    match[v2] = v1
                    return True
        return False
        
    maximum_flow = 0
    for i in range(N) :
        visited = [False] * M
        if dfs(i) :
            maximum_flow += 1
            if maximum_flow == N : break
    return maximum_flow


if __name__ == "__main__" :
    N, M = map(int, input().split())
    shirts = [int(input()) for _ in range(N)]
    collars = [int(input()) for _ in range(M)]
    print(bipartite_matching())
