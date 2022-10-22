from sys import stdin

if __name__ == "__main__" :
    N, M = map(int, input().split())
    A = sorted([int(stdin.readline().rstrip()) for _ in range(N)])
    left = right = 0
    min_val = int(2e9)
    while left < N and right <N :
        temp = A[right] - A[left]
        if temp < M :
            right += 1
        else :
            min_val = min(min_val, temp)
            left += 1
    print(min_val)
