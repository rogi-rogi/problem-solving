from sys import stdin
input = stdin.readline

words = sorted(list(set(input().strip() for _ in range(int(input())))))
print(*sorted(words, key = len), sep = '\n')
