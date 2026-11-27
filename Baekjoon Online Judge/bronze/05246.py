for _ in range(int(input())):
    rows = [0] * 8
    P = [*map(int, input().split())][1:]
    for y in P[1::2]:
        rows[y - 1] += 1
    print(max(rows))
