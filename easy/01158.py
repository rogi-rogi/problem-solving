from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N, K = map(int, input().split())
    queue = [*range(1, N + 1)]
    res = []

    # Solve
    idx = 0
    while queue:
        idx = (idx + K - 1) % len(queue)
        res.append(queue.pop(idx))

    # Output
    print('<' + str(res)[1:-1] + '>')
