from sys import setrecursionlimit, stdin
setrecursionlimit(10 ** 8)
input = stdin.readline

def Kruskal() :
    def find(v) :
        if parent[v] == v : return v
        parent[v] = find(parent[v])
        return parent[v]

    def union(v1, v2) :
        v1 = find(v1)
        v2 = find(v2)
        if v1 != v2 : 
            parent[max(v1, v2)] = min(v1, v2)
            return True
        return False
    
    parent = [i for i in range(V + 1)]
    MST_weight = 0
    edge_cnt = 0
    for w, v1, v2 in edges :
        if union(v1, v2) : 
            if edge_cnt >= V - 2 : break
            edge_cnt += 1
            MST_weight += w
    return MST_weight
    
if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = []
    MST_weight = 0
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges.append((w, v1, v2))
    edges.sort()
    print(Kruskal())
