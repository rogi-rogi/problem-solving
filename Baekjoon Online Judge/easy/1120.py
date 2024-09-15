from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    V = [*map(float, input().split())]

    # Solve
    total = 0
    for idx, num in enumerate(V):
        total += (idx + 1) * num

    res = total
    if total != 3.5:
        diff = 3.5 - total
        res = abs(diff / max(V))

    # Output
    print("%.3f" % res)
    
