from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N, K = map(int, input().split())

    # Solve
    ride = 0
    stand = 0
    for _ in range(N):
        a, b = map(int, input().split())
        ride += (a - b)
        if ride > K:
            stand = max(stand, ride - K)
            
    # Output
    print(stand)
