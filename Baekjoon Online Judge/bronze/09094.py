from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    res = []

    # Input
    for _ in range(int(input())):
        N, M = map(int, input().split())

        # Solve
        cnt = 0
        for a in range(1, N - 1):
            for b in range(a + 1, N):
                if (a**2 + b**2 + M) % (a*b) == 0:
                    cnt += 1
        res.append(cnt)

    # Output
    print(*res, sep='\n')
