from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    A = [0, *map(int, input().split())]

    # Solve
    prefix_sum = [0] * (N + 1)
    for i in range(1, N + 1):
        prefix_sum[i] = prefix_sum[i - 1] + A[i]

    answer = []
    for _ in range(int(input())):
        s, e = map(int, input().split())
        answer.append(prefix_sum[e] - prefix_sum[s - 1])

    # Output
    print(*answer, sep='\n')