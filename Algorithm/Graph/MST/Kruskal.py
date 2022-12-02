'''
[ Time Complexity ] : O (E log E)
target : undirected graph, sparse graph, sub graph
'''
class DisjointSet :
    def __init__(self, V) :
        self.parents = [*range(V + 1)]
    
    def find(self, v) :
        if self.parents[v] == v : return v
        self.parents[v] = self.find(self.parents[v])
        return self.parents[v]
        
    def union(self, v1, v2) :
        v1 = self.find(v1)
        v2 = self.find(v2)
        if v1 != v2 :
            self.parents[max(v1, v2)] = min(v1, v2)
            return True
        return False

def Kruskal(V, divide = 1) :
    graph = DisjointSet(V)
    MST_weight = 0
    connected_edge = 0
    for w, v1, v2 in edges :
        if graph.union(v1, v2) :
            MST_weight += w
            connected_edge += 1
            if connected_edge >= V - divide : break
    return MST_weight
    
if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = []
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges.append((w, v1, v2))
    edges.sort()
    print(Kruskal(V))
