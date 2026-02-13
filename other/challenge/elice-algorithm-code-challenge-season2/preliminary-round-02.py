from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    N, M = map(int, input().split())
    arr = [*map(int, input().split())]
    for _ in range(M):
        i, j, k = map(int, input().split())
        print(sorted(arr[i - 1:j])[k - 1])
