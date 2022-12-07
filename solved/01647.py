from sys import stdin
input = stdin.readline

class DisjointSet :
    def find(self, v, parents) :
        if parents[v] == v : return v
        parents[v] = self.find(parents[v], parents)
        return parents[v]
        
    def union(self, v1, v2, parents) :
        v1 = self.find(v1, parents)
        v2 = self.find(v2, parents)
        if v1 != v2 :
            parents[max(v1, v2)] = min(v1, v2)
            return True
        return False

def Kruskal(V, divide = 1) :
    parents = [*range(V + 1)]
    MST_weight = 0
    connected_edge = 0
    graph = DisjointSet()
    for v1, v2, w in edges :
        if graph.union(v1, v2, parents) :
            MST_weight += w
            connected_edge += 1
            if connected_edge >= V - divide : break
    return MST_weight
    
if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = sorted([tuple(map(int, input().split())) for _ in range(E)], key = lambda x : x[2])
    print(Kruskal(V, 2))
