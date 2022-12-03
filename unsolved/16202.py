from sys import stdin
input = stdin.readline

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

def Kruskal(V, k) :
    graph = DisjointSet(V)
    for w, v1, v2 in edges :
        if graph.union(v1, v2, w) :
            if graph.connected_edge >= V - 1 : return graph.weight
    return -1
    
if __name__ == "__main__" :
    V, E, K = map(int, input().split())
    edges = []
    for e in range(1, E + 1) :
        v1, v2 = map(int, input().split())
        edges.append((e, v1, v2))
    edges.sort()
    res = []
    for k in range(K) :
        weight = Kruskal(V, k)
        res.append((weight, 0)[weight == -1])
        del edges[0]
    print(*res)
