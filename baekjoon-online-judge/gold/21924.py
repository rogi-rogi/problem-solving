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

def Kruskal(V) :
    parents = [*range(V + 1)]
    MST_weight = 0
    connected_edge = 0
    graph = DisjointSet()
    for w, v1, v2 in edges :
        if graph.union(v1, v2, parents) :
            MST_weight += w
            connected_edge += 1
            if connected_edge >= V - 1 : return MST_weight
    return -1
    
if __name__ == "__main__" :
    V, E = map(int, input().split())
    edges = []
    sum_weight = 0
    for _ in range(E) :
        v1, v2, w = map(int, input().split())
        sum_weight += w
        edges.append((w, v1, v2))
    edges.sort()
    weight = Kruskal(V)
    print([sum_weight - weight, -1][weight == -1])
