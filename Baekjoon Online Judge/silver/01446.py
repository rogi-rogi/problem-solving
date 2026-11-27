N, D = map(int, input().split())
graph = [[*map(int, input().split())] for _ in range(N)]
dist = [i for i in range(D + 1)]
for i in range(D + 1) :
    if i > 0 : dist[i] = min(dist[i], dist[i - 1] + 1)
    for s, e, d in graph :
        if i == s and e <= D and dist[i] + d < dist[e] :
            dist[e] = dist[i] + d
print(dist[D])
