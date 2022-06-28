R, C = map(int, input().split())
words = [[*input()] for _ in range(R)]
visited = [[[False] * 2 for _ in range(C)] for _ in range(R)]
res = []
for i in range(R) :
    for j in range(C) :
        for d in range(2) :
            if not visited[i][j][d] :
                temp = ""
                nx, ny = i, j
                while nx < R and ny < C and words[nx][ny] != '#' :
                    visited[nx][ny][d] = True
                    temp += words[nx][ny]
                    nx, ny = [(nx + 1, ny), (nx, ny + 1)][d == 0]
                if nx - i > 1 or ny - j > 1 : res.append(temp)
print(*sorted(res)[0], sep = '')
