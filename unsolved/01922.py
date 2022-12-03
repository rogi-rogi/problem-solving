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
        
def Kruskal(V) :
    graph = DisjointSet(V)
    for v1, v2, w in edges :
        if graph.union(v1, v2, w) :
            if graph.connected_edge >= V - 1 : break
    return graph.weight
    
if __name__ == "__main__" :
    V = int(input())
    E = int(input())
    edges = sorted([tuple(map(int, input().split())) for _ in range(E)], key = lambda x : x[2])
    print(Kruskal(V))
