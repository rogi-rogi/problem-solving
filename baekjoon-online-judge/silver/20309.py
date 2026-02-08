from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    arr = [*map(int, input().split())]

    # Solve
    res = "YES"
    for i in range(N):
        if arr[i] % 2 != (i + 1) % 2:
            res = "NO"
            break
        
    # Output
    print(res)
