from sys import stdin
input = stdin.readline

def FloydWarshall() :
    for t in range(1, V + 1) :
        for v1 in range(1, V + 1) :
            for v2 in range(1, V + 1) :
                if v1 == v2 : edges[v1][v2] = 0
                w = edges[v1][t] + edges[t][v2]
                if edges[v1][v2] > w : edges[v1][v2] = w

# input
V, E = map(int, input().split())
edges = [[V] * (V + 1) for _ in range(V + 1)]
for _ in range(E) :
    v1, v2 = map(int, input().split())
    edges[v1][v2] = edges[v2][v1] = 1
    
# calc
FloydWarshall()
step = [sum(edges[i][1:]) for i in range(1, V + 1)]
print(step.index(min(step)) + 1)
