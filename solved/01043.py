from sys import stdin
input = stdin.readline

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


if __name__ == "__main__" :
    N, M = map(int, input().split())
    Graph = DisjointSet(N)
    know_truth = [*map(int, input().split())][1:]
    parties = []
    for _ in range(M) :
        party_info = [*map(int, input().split())]
        parties.append(party_info[1:])
        for i in range(1, party_info[0]) :
            Graph.union(party_info[i], party_info[i + 1])
    cnt = M
    for party in parties :
        for know in know_truth :
            if Graph.find(know) == Graph.find(party[0]) :
                cnt -= 1
                break
    print(cnt)
    
'''
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N, M = map(int, input().split())
    know_truth = set(input().split()[1:])
    parties = [set(input().split()[1:]) for _ in range(M)]
    for _ in range(M):
        for party in parties :
            if party & know_truth :
                know_truth = know_truth.union(party)
    cnt = M
    for party in parties :
        if party & know_truth : cnt -= 1
    print(cnt)
'''
