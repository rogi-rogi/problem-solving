from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    A = [9.23076, 1.84523, 56.0211, 4.99087, 0.188807, 15.9803, 0.11193]
    B = [26.7, 75, 1.5, 42.5, 210, 3.8, 254]
    C = [1.835, 1.348, 1.05, 1.81, 1.41, 1.04, 1.88]
    isTrack = [1, 0, 0, 1, 0, 0, 1]
    res = []

    # Input
    for _ in range(int(input())):
        P = [*map(int, input().split())]

        # Solve
        score = 0
        for a, b, c, p, t in zip(A, B, C, P, isTrack):
            if t == 1:
                score += int(a * (b - p) ** c)
            else:
                score += int(a * (p - b) ** c)
        res.append(score)

    # Output
    print(*res, sep='\n')
