'''
[Time Complexity] : O(VE)
All Capacity : 1
X, Y : other group
'''
  
def BipartiteMatching(Y) :
    def DFS(v1) :
        for v2 in edges[v1] :
            if connected[v2] : continue
            connected[v2] = True
            if not path[v2] or DFS(path[v2]) :
                path[v2] = v1
                return True
        return False
    
    maximum_flow = 0
    connected = None
    path = [0] * (Y + 1)
    for i in range(1, X + 1) :
        connected = [False] * (Y + 1)
        if DFS(i) : maximum_flow += 1
    return maximum_flow

if __name__ == "__main__" :
    X, Y, E = map(int, input().split())
    edges = [[] for _ in range(X + 1)]
    for _ in range(E) :
        v1, v2 = map(int, input().split())
        edges[v1].append(v2)
    maximum_flow = BipartiteMatching()
    print(maximum_flow)
