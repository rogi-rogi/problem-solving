R, C = map(int, input().split())
words = [[*input()] for _ in range(R)]
visited = [[[False] * 2 for _ in range(C)] for _ in range(R)]
res = []
for i in range(R) :
    for j in range(C) :
        for k in range(2) :
            if not visited[i][j][k] :
                temp = ""
                nx, ny = i, j
                if k == 0 :
                    while ny < C and words[i][ny] != '#' :
                        temp += words[i][ny]
                        visited[i][ny][k] = True
                        ny += 1
                elif k == 1 :
                    while nx < R and words[nx][j] != '#' :
                        temp += words[nx][j]
                        visited[nx][j][k] = True
                        nx += 1
                if len(temp) > 1 :
                    res.append(temp)
print(*sorted(res)[0], sep = '')
