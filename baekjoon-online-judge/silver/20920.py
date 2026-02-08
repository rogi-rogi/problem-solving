from collections import defaultdict, deque
from sys import stdin
input = stdin.readline


if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())

    # Solve
    words = defaultdict(int)
    for _ in range(N):
        word = input().rstrip()
        if len(word) >= M:
            words[word] += 1
    sort_words = dict(sorted(words.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))).keys()

    # Output
    print(*sort_words, sep='\n')
    
