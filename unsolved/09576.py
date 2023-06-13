from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    for _ in range(int(input())) :
        N, M = map(int, input().split())
        graph = [[*map(int, input().split())] for _ in range(M)]
        graph.sort(key = lambda x : x[1])
        match = [False] * (N + 1)
        cnt = 0
        for a, b in graph :
            for i in range(a, b + 1) :
                if not match[i] :
                    cnt += 1
                    match[i] = True
                    break
        print(cnt)
