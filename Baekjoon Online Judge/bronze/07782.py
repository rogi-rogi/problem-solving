from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    b1, b2 = map(int, input().split())

    # Solve
    res = "No"
    for _ in range(N):
        a, b, c, d = map(int, input().split())
        if a <= b1 <= c and b <= b2 <= d:
            res = "Yes"
            break

    # Output
    print(res)
    
