from sys import stdin
input = stdin.readline

'''
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
    for w, v1, v2 in edges :
        if graph.union(v1, v2, parents) :
            MST_weight += w
            connected_edge += 1
            if connected_edge >= V - divide : break
    return MST_weight
''' # slow...

def find(parents, v) :
    if parents[v] == v : return v
    parents[v] = find(parents, parents[v])
    return parents[v]
    
def union(parents, v1, v2) :
    v1 = find(parents, v1)
    v2 = find(parents, v2)
    if v1 != v2 :
        parents[max(v1, v2)] = min(v1, v2)
        return True
    return False

def Kruskal(V) :
    parents = [*range(V + 1)]
    MST_weight = 0
    connected_edge = 0
    for w, v1, v2 in edges :
        if union(parents, v1, v2) :
            MST_weight += w
            connected_edge += 1
            if connected_edge >= V - 1 : break
    return MST_weight
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        R, C = map(int, input().split())
        edges = []
        vertex = 1
        for r in range(R) :
            for weight in [*map(int, input().split())] :
                edges.append((weight, vertex, vertex + 1))
                vertex += 1
            vertex += 1
        vertex = 1
        for r in range(R - 1) :
            weights = [*map(int, input().split())]
            for c in range(C) :
                edges.append((weights[c], vertex, vertex + C))
                if c != C - 1 : vertex += 1
            vertex += 1
        edges.sort()
        print(Kruskal(R * C))
