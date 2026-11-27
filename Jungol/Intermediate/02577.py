from sys import stdin
from collections import defaultdict

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, _, K, C = map(int, input().split())
    A = [int(input()) for _ in range(N)]

    # Solve
    sushi_count = defaultdict(int)

    for i in range(K):
        sushi_count[A[i]] += 1

    sushi_count[C] += 1
    answer = len(sushi_count)

    for left in range(N):
        right = (left + K) % N

        sushi_count[A[left]] -= 1
        if sushi_count[A[left]] == 0:
            del sushi_count[A[left]]

        sushi_count[A[right]] += 1

        answer = max(answer, len(sushi_count))

    # Output
    print(answer)