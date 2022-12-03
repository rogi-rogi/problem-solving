'''
[ Time Complexity ] : O (E log E)
target : undirected graph, sparse graph
'''
class DisjointSet :
    def __init__(self, V) :
        self.parents = [*range(V + 1)]
        self.weight = 0
        self.connected_edge = 0
        
    def find(self, v) :
        if self.parents[v] == v : return v
        self.parents[v] = self.find(self.parents[v])
        return self.parents[v]
        
    def union(self, v1, v2, w) :
        v1 = self.find(v1)
        v2 = self.find(v2)
        if v1 != v2 :
            self.parents[max(v1, v2)] = min(v1, v2)
            self.weight += w
            self.connected_edge += 1
            return True
        return False

def Kruskal(V, divide = 1) :
    graph = DisjointSet(V)
    for w, v1, v2 in edges :
        if graph.union(v1, v2, w) :
            if graph.connected_edge >= V - divide : return graph.weight
    return -1
    
if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = []
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        edges.append((w, v1, v2))
    edges.sort()
    print(Kruskal(V))
