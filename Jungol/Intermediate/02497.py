from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, K = map(int, input().split())
    A = [*map(int, input().split())]

    # Solve
    sub_sum = sum(A[:K])
    answer = sub_sum

    left, right = 0, K
    for i in range(K, N):
        sub_sum -= A[i - K]
        sub_sum += A[i]
        answer = max(answer, sub_sum)

    # Output
    print(answer)