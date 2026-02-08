from sys import stdin
input = stdin.readline

def reverse(i, j):
    for ri in range(i, i + 3):
        for rj in range(j, j + 3):
            if A[ri][rj] == '0':
                A[ri][rj] = '1'
            else:
                A[ri][rj] = '0'

if __name__ == '__main__':
    N, M = map(int, input().split())
    A = [[*input().rstrip()] for _ in range(N)]
    B = [[*input().rstrip()] for _ in range(N)]
    if (N < 3 or M < 3) and A != B:
        print(-1)
    else:
        cnt = 0
        for i in range(N - 2):
            for j in range(M - 2):
                if A[i][j] != B[i][j]:
                    cnt += 1
                    reverse(i, j)
        print(cnt if A == B else -1)
