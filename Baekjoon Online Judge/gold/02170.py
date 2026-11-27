from sys import stdin
input = stdin.readline

INF = int(1e10)

if __name__ == "__main__" :
    N = int(input())
    lines = [[*map(int, input().split())] for _ in range(N)]
    lines.sort()
    x, y = -INF, -INF
    res = 0
    for line in lines :
        if line[0] > y :
            res += (y - x)
            x, y = line
        elif line[1] > y :
            y = line[1]
    print(res + (y - x))
