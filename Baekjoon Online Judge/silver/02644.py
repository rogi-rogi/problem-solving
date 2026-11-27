from sys import stdin
input = stdin.readline

def dfs(r):
    for i in relative[r]:
        if visited[i] == 0 :
            visited[i] = visited[r] + 1
            dfs(i)
            
n = int(input())
relative = [[] for _ in range(n + 1)]
child, parent = map(int, input().split())

for _ in range(int(input())) :
    x, y = map(int, input().split())
    relative[x].append(y)
    relative[y].append(x)

visited = [0] * (n + 1)
dfs(child)
print(visited[parent] if visited[parent] > 0 else -1)
