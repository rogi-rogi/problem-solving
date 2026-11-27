from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N, K, X, Y = map(int, input().split())

    # Solve
    cnt = 0
    for _ in range(N):
        x, y = map(int, input().split())
        d = (abs(X - x)**2 + abs(Y - y)**2)**(1/2)
        if d > K:
            cnt += 1

    # Output
    print(cnt)
