from collections import defaultdict
from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    words = [*input().split()]

    cnt = defaultdict(int)
    # Solve
    for word in words:
        for char in word:
            cnt[char] += 1
    
    # Output
    print(max(cnt.values()))
