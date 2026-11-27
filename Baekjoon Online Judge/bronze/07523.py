from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    for TC in range(1, int(input()) + 1):
        # Input
        N, M = map(int, input().split())

        # Solve
        res = (M - N + 1) * (N + M) // 2

        # Output
        print(f"Scenario #{TC}:\n{res}\n")
