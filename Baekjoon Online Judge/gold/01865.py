from sys import stdin
input = stdin.readline

def adhoc_bellman_ford() :
    dist = [0] * (N + 1)
    for cycle in range(N) :
        for u in range(1, N + 1) :
            for v, w in graph[u] :
                if dist[u] + w < dist[v] :
                    dist[v] = dist[u] + w
                    if cycle == N - 1 : return True
    return False
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        N, M, W = map(int, input().split())
        graph = [[] for _ in range(N + 1)]
        for _ in range(M) :
            S, E, T = map(int, input().split())
            graph[S].append((E, T))
            graph[E].append((S, T))
        for _ in range(W) :
            S, E, T = map(int, input().split())
            graph[S].append((E, -T))
        print(["NO", "YES"][adhoc_bellman_ford()])
      
'''
from math import inf
from sys import stdin

input = stdin.readline

def bellman_ford(start) :
    dist[start] = 0
    for _ in range(N - 1) :
        for u, v, w in graph :
            if dist[u] != inf and dist[u] + w < dist[v] :
                dist[v] = dist[u] + w
    for u, v, w in graph :
        if dist[u] + w < dist[v] :
            return True
    return False
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        N, M, W = map(int, input().split())
        graph = []
        for _ in range(M) :
            S, E, T = map(int, input().split())
            graph.append((S, E, T))
            graph.append((E, S, T))
        for _ in range(W) :
            S, E, T = map(int, input().split())
            graph.append((S, E, -T))
            
        dist = [inf] * (N + 1)
        for start in range(1, N + 1) :
            if dist[start] == inf and bellman_ford(start):
                print("YES")
                break
        else : print("NO")
'''
