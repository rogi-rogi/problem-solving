from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N, X = map(int, input().split())

    res = -1
    for _ in range(N):
        S, T = map(int, input().split())

        # Solve
        if res < S and S + T <= X:
            res = S

    # Output
    print(res)
