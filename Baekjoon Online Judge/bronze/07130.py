from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    M, H = map(int, input().split())
    N = int(input())

    # Solve
    res = 0
    for i in range(N):
        C, B = map(int, input().split())
        res += max(M * C, H * B)

    # Output
    print(res)
    
